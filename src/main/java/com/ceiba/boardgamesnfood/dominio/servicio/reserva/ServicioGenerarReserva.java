package com.ceiba.boardgamesnfood.dominio.servicio.reserva;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva.AsignadorMesas;
import com.ceiba.boardgamesnfood.utils.DateUtils;

@Component
public class ServicioGenerarReserva {

	private static final int DURACION_HORAS_RESERVA = 5;

	private final AsignadorMesas asignadorMesas;
	
	private final RepositorioReserva repositorioReserva;
	
	@Autowired
	public ServicioGenerarReserva(RepositorioReserva repositorioReserva, AsignadorMesas asignadorMesas) {
		this.repositorioReserva = repositorioReserva;
		this.asignadorMesas = asignadorMesas;
	}

	public Reserva generarReserva(Reserva prospectoReserva, List<Table> mesasDisponibles) {
		Date fechaFinReserva = obtenerFechaFinReserva(prospectoReserva.getFechaInicioReserva());
		
		List<MesasPorReserva> mesasReserva = asignadorMesas.asignarMesasReserva(prospectoReserva, mesasDisponibles);
		
		prospectoReserva = asignarMesasYFechaAReserva(prospectoReserva, mesasReserva, fechaFinReserva);
		
		return repositorioReserva.agregar(prospectoReserva);
		
	}

	private Date obtenerFechaFinReserva(Date fechaInicioReserva) {
		return DateUtils.agregarHorasDate(fechaInicioReserva, DURACION_HORAS_RESERVA);
	}

	private Reserva asignarMesasYFechaAReserva(Reserva prospectoReserva, List<MesasPorReserva> mesasDisponibles,
			Date fechaFinReserva) {

		return new Reserva(null, mesasDisponibles, prospectoReserva.getFechaInicioReserva(), fechaFinReserva,
				prospectoReserva.getCantidadPersonas(), prospectoReserva.getTitular(), prospectoReserva.getJuego());
	}
	
	

}
