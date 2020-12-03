package com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.testdatabuilder.MesaTestDataBuilder;
import com.ceiba.boardgamesnfood.testdatabuilder.ReservaTestDataBuilder;

public class AsignadorMesasTest {
	
	@Test
	public void debeAsignar1MesaCuandoCantidadPersonasIgual_4() {
		
		AsignadorMesas asignadorMesas = new AsignadorMesas();
		
		Reserva reserva = ReservaTestDataBuilder.build()
				.conTitular("titular")
				.conJuego(JuegoType.EXPLODING_KITTENS)
				.conCantidadPersonas(4)
				.getResult();
		
		List<MesasPorReserva> mesasReserva = asignadorMesas.asignarMesasReserva(
				reserva, 
				MesaTestDataBuilder.defaultTestMesasList());
		
		assertThat(mesasReserva, is(notNullValue()));
		assertThat(mesasReserva.isEmpty(), is(false));
		assertThat(mesasReserva.size(), equalTo(1));
		
	}
	
	@Test
	public void debeAsignar2MesasCuandoCantidadPersonasIgual_8() {
		
		AsignadorMesas asignadorMesas = new AsignadorMesas();
		
		Reserva reserva = ReservaTestDataBuilder.build()
				.conTitular("titular")
				.conJuego(JuegoType.EXPLODING_KITTENS)
				.conCantidadPersonas(8)
				.getResult();
		
		List<MesasPorReserva> mesasReserva = asignadorMesas.asignarMesasReserva(
				reserva, 
				MesaTestDataBuilder.defaultTestMesasList());
		
		assertThat(mesasReserva, is(notNullValue()));
		assertThat(mesasReserva.isEmpty(), is(false));
		assertThat(mesasReserva.size(), equalTo(2));
		
	}

}
