package com.ceiba.boardgamesnfood.dominio.servicio.vendedor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.excepcion.CantidadPersonasSuperadasException;
import com.ceiba.boardgamesnfood.dominio.excepcion.MesasDisponiblesNoEncontradasException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.builder.MesasPorReservaBuilder;

public class ServicioGenerarReserva {


	private static final int MESAS_RESERVA_GRANDE = 2;
	private static final int CANTIDAD_MAXIMA_PERSONAS_POR_MESA = 4;
	
	private RepositorioMesasPorReserva repositorioMesasPorReserva;
	private RepositorioReserva repositorioReserva;

	
	/*
	 * TODO Todo el dominio debe ser puro
	 * el dom no debe tener dependencias externas
	 * 
	 * Aplicacion debe conocer el dominio
	 * 
	 * Infra puede conocer aplicacion tanto como el dominio
	 */
	public ServicioGenerarReserva(
			RepositorioMesasPorReserva repositorioMesasPorReserva,
			RepositorioReserva repositorioReserva) {
		this.repositorioMesasPorReserva = repositorioMesasPorReserva;
		this.repositorioReserva = repositorioReserva;
	}

	public void generarReserva(ComandoReserva comandoReserva) {
		List<Mesa> mesas = obtenerMesasDisponiblesByFecha(comandoReserva.getFechaReserva());
		
		Date fechaFinReserva = null;
		
		Reserva reserva = crearReserva(
				comandoReserva.getFechaReserva(),
				fechaFinReserva,
				comandoReserva.getCantidadPersonas(),
				comandoReserva.getTitular(),
				comandoReserva.getJuego());
		
		List<MesasPorReserva> mesasDisponibles = asignarMesasReserva(reserva, mesas, comandoReserva.getJuego(),
				comandoReserva.getCantidadPersonas());
		
		reserva.setMesas(mesasDisponibles);
		
		repositorioReserva.agregar(reserva);
		
	}

	private List<MesasPorReserva> asignarMesasReserva(Reserva reserva, List<Mesa> mesas, JuegoType juego,
			int cantidadPersonas) {
		List<MesasPorReserva> mesasPorReservas = new ArrayList<>();
		if (cantidadPersonas > juego.getCantidadJugadoresMaxima()) {
			throw new CantidadPersonasSuperadasException();
		}
		
		if (cantidadPersonas > CANTIDAD_MAXIMA_PERSONAS_POR_MESA) {
			validarReservaGrande(mesas);
			mesasPorReservas.add(asignarMesaDisponible(reserva, mesas.get(1)));
		}
		
		mesasPorReservas.add(asignarMesaDisponible(reserva, mesas.get(0)));
		
		return mesasPorReservas;
	}

	private void validarReservaGrande(List<Mesa> mesas) {
		if (mesas.size() < MESAS_RESERVA_GRANDE) {
			throw new MesasDisponiblesNoEncontradasException();
		}
	}

	private MesasPorReserva asignarMesaDisponible(Reserva reserva, Mesa mesa) {
		return MesasPorReservaBuilder.build()
		.conMesa(mesa)
		.conReserva(reserva)
		.getResult();
	}

	private List<Mesa> obtenerMesasDisponiblesByFecha(Date fechaReserva) {
		List<Mesa> mesasDisponibles = repositorioMesasPorReserva.obtenerMesasDisponiblesByFecha(fechaReserva);
		if (mesasDisponibles == null || mesasDisponibles.isEmpty()) {
			throw new MesasDisponiblesNoEncontradasException();
		}
		return mesasDisponibles;
	}

	public Reserva crearReserva(Date fechaInicioReserva, Date fechaFinReserva,
			int cantidadPersonas, String titular, JuegoType juego) {

		return new Reserva(null, null, fechaInicioReserva, fechaFinReserva, cantidadPersonas, titular, juego);
	}

}
