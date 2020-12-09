package com.ceiba.boardgamesnfood.infraestructura.persistencia.converter;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.ReservaEntity;

public final class ReservaConverter {

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
	

	public static ReservaEntity convertirAEntity(Reserva reserva) {
		ReservaEntity reservaEntity = new ReservaEntity();
		
		reservaEntity.setId(reserva.getId());
		reservaEntity.setCantidadPersonas(reserva.getCantidadPersonas());
		reservaEntity.setFechaFinReserva(reserva.getFechaFinReserva());
		reservaEntity.setFechaInicioReserva(reserva.getFechaInicioReserva());
		reservaEntity.setJuego(reserva.getJuego());
		reservaEntity.setTitular(reserva.getTitular());
		reservaEntity.setMesas(MesasPorReservaConverter.convertirAEntityList(reserva.getMesas()));

		return reservaEntity;
	}
}
