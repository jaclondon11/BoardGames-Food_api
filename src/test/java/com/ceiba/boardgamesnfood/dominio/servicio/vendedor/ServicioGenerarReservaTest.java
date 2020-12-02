package com.ceiba.boardgamesnfood.dominio.servicio.vendedor;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;

public class ServicioGenerarReservaTest {
	
	@Test
	public void debeIndicarNoDisnobilidadDeMesasSiFechaReservaNoCuentaConMesas() {
		
		
		//arrange
		RepositorioMesasPorReserva repositorioMesasPorReserva = mock(RepositorioMesasPorReserva.class);
		RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
		ServicioGenerarReserva servicio = new ServicioGenerarReserva(repositorioMesasPorReserva, repositorioReserva);
		
		//act
		
		
		//assert
	}

}
