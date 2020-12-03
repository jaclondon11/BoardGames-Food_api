package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;

public interface RepositorioMesaJPA {

	/**
	 * Permite obtener una mesa entity por un codigo
	 * @param codigo
	 * @return
	 */
	MesaEntity obtenerMesaEntityPorCodigo(String codigo);

	/**
	 * Permite obtener toda la lista de mesas entity
	 * @return
	 */
	List<MesaEntity> obtenerMesasEntity();

}
