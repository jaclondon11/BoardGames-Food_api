package com.ceiba.boardgamesnfood.dominio.repositorio;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.Mesa;

public interface RepositorioReserva {
	
	/**
	 * Permite obtener una garantia extendida por el codigo del producto
	 * @param codigo
	 * @param codigo
	 * @return entity o null si no existe
	 */
	Reserva obtener(String codigo);

	/**
	 * Permite obtener un producto con garantia extendida dado un codigo
	 * @param codigo
	 * @return
	 */
	Mesa obtenerProductoConGarantiaPorCodigo(String codigo);
	
	/**
	 * Permite agregar una garantia al repositorio de garantia
	 * @param garantia
	 */
	void agregar(Reserva garantia);
	
}
