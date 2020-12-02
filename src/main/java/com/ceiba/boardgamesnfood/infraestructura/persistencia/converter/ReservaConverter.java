package com.ceiba.boardgamesnfood.infraestructura.persistencia.converter;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.ReservaEntity;

public class ReservaConverter {

	private ReservaConverter() {
	}

	public static Reserva convertirADominio(ReservaEntity reservaEntity) {
		Reserva reserva = null;

		if (reservaEntity != null) {
			reserva = new Reserva(
					reservaEntity.getId(), 
					MesasPorReservaConverter.convertirADominioList(reservaEntity.getMesasReserva()),
					reservaEntity.getFechaInicioReserva(),
					reservaEntity.getFechaFinReserva(),
					reservaEntity.getCantidadPersonas(),
					reservaEntity.getTitular(),
					reservaEntity.getJuego());
		}

		return reserva;
	}
	

	public static MesaEntity convertirAEntity(Mesa mesa) {
		MesaEntity mesaEntity = new MesaEntity();
		
		mesaEntity.setId(mesa.getId());
		mesaEntity.setCodigo(mesa.getCodigo());

		return mesaEntity;
	}
}
