package com.ceiba.boardgamesnfood.dominio.repositorio;

import java.util.List;

import com.ceiba.boardgamesnfood.dominio.Table;

public interface RepositorioMesa {

	/**
	 * Permite obtener una mesa dado un codigo
	 * 
	 * @param codigo
	 * @return
	 */
	Table obtenerPorCodigo(String codigo);

	/**
	 * Permite agregar una mesa al repositorio
	 * 
	 * @param mesa
	 */
	void agregar(Table mesa);
	
	/**
	 * Permite obtener todas las mesas 
	 * @return
	 */
	List<Table> obtenerMesas();

}