package com.ceiba.boardgamesnfood.infraestructura.persistencia.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesasPorReservaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.ReservaEntity;

public class MesasPorReservaConverter {

	private MesasPorReservaConverter() {
	}

	public static MesasPorReserva convertirADominio(MesasPorReservaEntity mesasReservaEntity) {
		MesasPorReserva mesaReserva = null;

		if (mesasReservaEntity != null) {
			Reserva reserva = new Reserva(mesasReservaEntity.getReserva().getId());

			mesaReserva = new MesasPorReserva(
					mesasReservaEntity.getId(),
					MesaConverter.convertirADominio(mesasReservaEntity.getMesa()),
					reserva);
		}

		return mesaReserva;
	}
	

	public static MesasPorReservaEntity convertirAEntity(MesasPorReserva mesaReserva) {
		MesasPorReservaEntity mesaEntity = new MesasPorReservaEntity();
		
		mesaEntity.setId(mesaReserva.getId());
		mesaEntity.setMesa(MesaConverter.convertirAEntity(mesaReserva.getMesa()));
		ReservaEntity reservaEntity = new ReservaEntity();
		reservaEntity.setId(mesaReserva.getReserva().getId());
		mesaEntity.setReserva(reservaEntity);

		return mesaEntity;
	}
	
	public static List<MesasPorReserva> convertirADominioList(List<MesasPorReservaEntity> mesasReservaEntityList) {
		List<MesasPorReserva> mesasReserva = null;
		
		if (mesasReservaEntityList != null) {
			mesasReserva = mesasReservaEntityList.stream()
					.map(MesasPorReservaConverter::convertirADominio)
					.collect(Collectors.toList());
		}
		
		return mesasReserva;
	}
	
	public static List<MesasPorReservaEntity> convertirAEntityList(List<MesasPorReserva> mesasReservaList) {
		List<MesasPorReservaEntity> mesasReservaEntityList = null;
		
		if (mesasReservaList != null) {
			mesasReservaEntityList = mesasReservaList.stream()
					.map(MesasPorReservaConverter::convertirAEntity)
					.collect(Collectors.toList());
		}
		
		return mesasReservaEntityList;
	}
}
