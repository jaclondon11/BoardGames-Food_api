package com.ceiba.boardgamesnfood.dominio.repositorio;

import com.ceiba.boardgamesnfood.dominio.Mesa;

public interface RepositorioMesa {

	/**
	 * Permite obtener una mesa dado un codigo
	 * @param codigo
	 * @return
	 */
	Mesa obtenerPorCodigo(String codigo);

	/**
	 * Permite agregar una mesa al repositorio
	 * @param producto
	 */
	void agregar(Mesa producto);

}