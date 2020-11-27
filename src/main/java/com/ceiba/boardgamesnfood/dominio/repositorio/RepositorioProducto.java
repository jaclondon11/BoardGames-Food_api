package com.ceiba.boardgamesnfood.dominio.repositorio;

import com.ceiba.boardgamesnfood.dominio.Mesa;

public interface RepositorioProducto {

	/**
	 * Permite obtener un producto dado un codigo
	 * @param codigo
	 * @return
	 */
	Mesa obtenerPorCodigo(String codigo);

	/**
	 * Permite agregar un producto al repositorio
	 * @param producto
	 */
	void agregar(Mesa producto);

}