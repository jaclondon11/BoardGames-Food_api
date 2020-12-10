package com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.excepcion.MesasDisponiblesNoEncontradasException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesasPorReserva;
import com.ceiba.boardgamesnfood.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.boardgamesnfood.utils.DateUtils;
public class ServicioObtenerMesasDisponibleTest {

	@Test
	public void debeRetornarMesasDisponiblesSiMesasNoHayMesasOcupadas() {
		
		//arrange
		RepositorioMesasPorReserva repositorioMesasPorReserva = mock(RepositorioMesasPorReserva.class);
		RepositorioMesa repositorioReserva = mock(RepositorioMesa.class);
		
		ServicioObtenerMesasDisponibles servicio = new ServicioObtenerMesasDisponibles(
						repositorioMesasPorReserva,
						repositorioReserva);
		
		Date fechaInicioReserva = DateUtils
				.convertirLocalDateTimeToDate(LocalDateTime.of(2020, Month.DECEMBER, 2, 17, 0, 0));
		
		
		when(repositorioMesasPorReserva.obtenerMesasConReservaByFecha(fechaInicioReserva)).thenReturn(new ArrayList<>());
		when(repositorioReserva.obtenerMesas()).thenReturn(MesaTestDataBuilder.defaultTestMesasList());
		
		//act
		List<Table> mesasDisponibles = servicio.obtenerMesasDisponiblesByFecha(fechaInicioReserva);
		
		//assert
		assertThat(mesasDisponibles, is(notNullValue()));
		assertThat(mesasDisponibles.isEmpty(), is(false));
	}
	
	@Test
	public void noDebeRetornarMesasDisponiblesSiMesasEstanTodasReservadas() {
		
		//arrange
		RepositorioMesasPorReserva repositorioMesasPorReserva = mock(RepositorioMesasPorReserva.class);
		RepositorioMesa repositorioReserva = mock(RepositorioMesa.class);
		
		ServicioObtenerMesasDisponibles servicio = new ServicioObtenerMesasDisponibles(
						repositorioMesasPorReserva,
						repositorioReserva);
		
		Date fechaInicioReserva = DateUtils
				.convertirLocalDateTimeToDate(LocalDateTime.of(2020, Month.DECEMBER, 2, 17, 0, 0));
		
		
		when(repositorioMesasPorReserva.obtenerMesasConReservaByFecha(fechaInicioReserva)).thenReturn(MesaTestDataBuilder.defaultTestMesasList());
		when(repositorioReserva.obtenerMesas()).thenReturn(MesaTestDataBuilder.defaultTestMesasList());
		
		//act
		try {
			servicio.obtenerMesasDisponiblesByFecha(fechaInicioReserva);
		} catch (Exception e) {
			
			//assert
			assertThat(e instanceof MesasDisponiblesNoEncontradasException, is(true));
		}
		
		
		
	}

}
