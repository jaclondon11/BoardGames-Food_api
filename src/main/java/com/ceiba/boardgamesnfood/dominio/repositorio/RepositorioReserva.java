package com.ceiba.boardgamesnfood.dominio.repositorio;

import com.ceiba.boardgamesnfood.dominio.Reserva;

public interface RepositorioReserva {
	
	/**
	 * Permite obtener una reverva por el id
	 * @param id
	 * @return entity o null si no existe
	 */
	Reserva obtener(Long id);

	/**
	 * Permite agregar una reserva al repositorio de reserva
	 * @param reserva
	 * @return 
	 */
	Reserva agregar(Reserva reserva);
	
}
