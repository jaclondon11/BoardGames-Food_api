package com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.boardgamesnfood.testdatabuilder.ReservaTestDataBuilder;

public class AsignadorMesasTest {
	
	@Test
	public void debeAsignar1MesaCuandoCantidadPersonasIgual_4() throws ParseException {
		Date fecha = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-12-04-15:00:00");
		
		AsignadorMesas asignadorMesas = new AsignadorMesas();
		
		Reserva reserva = ReservaTestDataBuilder.build()
				.conTitular("titular")
				.conJuego(JuegoType.EXPLODING_KITTENS)
				.conCantidadPersonas(4)
				.conFecha(fecha)
				.getResult();
		
		List<MesasPorReserva> mesasReserva = asignadorMesas.asignarMesasReserva(
				reserva, 
				MesaTestDataBuilder.defaultTestMesasList());
		
		assertThat(mesasReserva, is(notNullValue()));
		assertThat(mesasReserva.isEmpty(), is(false));
		assertThat(mesasReserva.size(), equalTo(1));
		
	}
	
	@Test
	public void debeAsignar2MesasCuandoCantidadPersonasIgual_8() throws ParseException {
		Date fecha = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-12-04-15:00:00");

		
		AsignadorMesas asignadorMesas = new AsignadorMesas();
		
		Reserva reserva = ReservaTestDataBuilder.build()
				.conTitular("titular")
				.conJuego(JuegoType.EXPLODING_KITTENS)
				.conCantidadPersonas(8)
				.conFecha(fecha)
				.getResult();
		
		List<MesasPorReserva> mesasReserva = asignadorMesas.asignarMesasReserva(
				reserva, 
				MesaTestDataBuilder.defaultTestMesasList());
		
		assertThat(mesasReserva, is(notNullValue()));
		assertThat(mesasReserva.isEmpty(), is(false));
		assertThat(mesasReserva.size(), equalTo(2));
		
	}

}
