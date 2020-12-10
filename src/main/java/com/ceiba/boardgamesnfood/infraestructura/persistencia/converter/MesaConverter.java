package com.ceiba.boardgamesnfood.infraestructura.persistencia.converter;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;

public final class MesaConverter {

	private MesaConverter() {
	}

	public static Table convertirADominio(MesaEntity mesaEntity) {
		Table mesa = null;

		if (mesaEntity != null) {
			mesa = new Table(mesaEntity.getId(), mesaEntity.getCodigo());
		}

		return mesa;
	}
	

	public static MesaEntity convertirAEntity(Table mesa) {
		MesaEntity mesaEntity = new MesaEntity();
		
		mesaEntity.setId(mesa.getId());
		mesaEntity.setCodigo(mesa.getCode());

		return mesaEntity;
	}
}
