package com.ceiba.boardgamesnfood.infraestructura.persistencia.builder;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;

public class MesaConverter {

	private MesaConverter() {
	}

	public static Mesa convertirADominio(MesaEntity mesaEntity) {
		Mesa mesa = null;

		if (mesaEntity != null) {
			mesa = new Mesa(mesaEntity.getId(), mesaEntity.getCodigo());
		}

		return mesa;
	}
	

	public static MesaEntity convertirAEntity(Mesa mesa) {
		MesaEntity mesaEntity = new MesaEntity();
		
		mesaEntity.setId(mesa.getId());
		mesaEntity.setCodigo(mesa.getCodigo());

		return mesaEntity;
	}
}
