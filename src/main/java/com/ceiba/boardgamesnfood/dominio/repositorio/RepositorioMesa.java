package com.ceiba.boardgamesnfood.dominio.repositorio;

import java.util.List;

import com.ceiba.boardgamesnfood.dominio.Mesa;

public interface RepositorioMesa {

	/**
	 * Permite obtener una mesa dado un codigo
	 * 
	 * @param codigo
	 * @return
	 */
	Mesa obtenerPorCodigo(String codigo);

	/**
	 * Permite agregar una mesa al repositorio
	 * 
	 * @param mesa
	 */
	void agregar(Mesa mesa);
	
	/**
	 * Permite obtener todas las mesas 
	 * @return
	 */
	List<Mesa> obtenerMesas();

}