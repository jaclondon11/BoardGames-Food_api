package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.jpa;

import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;

public interface RepositorioProductoJPA {

	/**
	 * Permite obtener un producto entity por un codigo
	 * @param codigo
	 * @return
	 */
	MesaEntity obtenerProductoEntityPorCodigo(String codigo);

}
