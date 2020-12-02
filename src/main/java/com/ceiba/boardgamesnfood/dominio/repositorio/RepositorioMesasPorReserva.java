package com.ceiba.boardgamesnfood.dominio.repositorio;

import java.util.Date;
import java.util.List;

import com.ceiba.boardgamesnfood.dominio.Mesa;

public interface RepositorioMesasPorReserva {
	
	/**
	 * Permite obtener mesas disponibles para una hora
	 * @param fechaReserva
	 * @return set de mesas disponibles
	 */
	List<Mesa> obtenerMesasDisponiblesByFecha(Date fechaReserva);

	
}
