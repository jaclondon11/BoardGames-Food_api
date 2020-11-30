package com.ceiba.boardgamesnfood.infraestructura.persistencia.builder;

import java.util.Set;
import java.util.stream.Collectors;

import com.ceiba.boardgamesnfood.dominio.MesasReserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesasReservaEntity;

public class MesaReservaConverter {

	private MesaReservaConverter() {
	}

	public static MesasReserva convertirADominio(MesasReservaEntity mesasReservaEntity) {
		MesasReserva mesa = null;

		if (mesasReservaEntity != null) {
			mesa = new MesasReserva(mesasReservaEntity.getId(),
					mesasReservaEntity.getMesa(),
					mesasReservaEntity.getReserva());
		}

		return mesa;
	}
	

	public static MesasReservaEntity convertirAEntity(MesasReserva mesaReserva) {
		MesasReservaEntity mesaEntity = new MesasReservaEntity();
		
		mesaEntity.setId(mesaReserva.getId());
		mesaEntity.setMesa(mesaReserva.getMesa());
		mesaEntity.setReserva(mesaReserva.getReserva());

		return mesaEntity;
	}
	
	public static Set<MesasReserva> convertirADominioSet(Set<MesasReservaEntity> mesasReservaEntitySet) {
		Set<MesasReserva> mesasReserva = null;
		
		if (mesasReservaEntitySet != null) {
			mesasReserva = mesasReservaEntitySet.stream()
					.map(MesaReservaConverter::convertirADominio)
					.collect(Collectors.toSet());
		}
		
		return mesasReserva;
	}
	
	public static Set<MesasReservaEntity> convertirAEntitySet(Set<MesasReserva> mesasReservaSet) {
		Set<MesasReservaEntity> mesasReservaEntitySet = null;
		
		if (mesasReservaSet != null) {
			mesasReservaEntitySet = mesasReservaSet.stream()
					.map(MesaReservaConverter::convertirAEntity)
					.collect(Collectors.toSet());
		}
		
		return mesasReservaEntitySet;
	}
}
