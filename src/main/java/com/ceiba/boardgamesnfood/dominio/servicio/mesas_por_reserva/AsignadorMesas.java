package com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.builder.MesasPorReservaBuilder;
import com.ceiba.boardgamesnfood.dominio.excepcion.CantidadPersonasSuperadasException;
import com.ceiba.boardgamesnfood.dominio.excepcion.MesasDisponiblesNoEncontradasException;

@Component
public class AsignadorMesas {
	
	private static final int MESAS_RESERVA_GRANDE = 2;
	private static final int CANTIDAD_MAXIMA_PERSONAS_POR_MESA = 4;
	
	public List<MesasPorReserva> asignarMesasReserva(Reserva reserva, List<Table> mesasDisponibles) {
		List<MesasPorReserva> mesasPorReservas = new ArrayList<>();
		if (reserva.getCantidadPersonas() > reserva.getJuego().getCantidadJugadoresMaxima()) {
			throw new CantidadPersonasSuperadasException();
		}
		
		if (reserva.getCantidadPersonas() > CANTIDAD_MAXIMA_PERSONAS_POR_MESA) {
			validarReservaGrande(mesasDisponibles);
			mesasPorReservas.add(asignarMesaDisponible(reserva, mesasDisponibles.get(1)));
		}
		
		mesasPorReservas.add(asignarMesaDisponible(reserva, mesasDisponibles.get(0)));
		
		return mesasPorReservas;
	}
	
	private void validarReservaGrande(List<Table> mesas) {
		if (mesas.size() < MESAS_RESERVA_GRANDE) {
			throw new MesasDisponiblesNoEncontradasException();
		}
	}

	private MesasPorReserva asignarMesaDisponible(Reserva reserva, Table mesa) {
		return MesasPorReservaBuilder.build()
		.conMesa(mesa)
		.conReserva(reserva)
		.getResult();
	}


}
