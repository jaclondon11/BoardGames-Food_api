package com.ceiba.boardgamesnfood.utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void debeAgregarN_HorasAFecha() {
		//arrange
		Date fecha = DateUtils.convertirLocalDateTimeToDate(LocalDateTime.of(2020, Month.DECEMBER, 2, 17, 0, 0));
		int horasASumar = 5;
		LocalDateTime fechaCalculada = DateUtils.convertirDateToLocalDateTime(fecha);
		Date fechaEsperadas = DateUtils.convertirLocalDateTimeToDate(LocalDateTime.of(2020, Month.DECEMBER, 2, 22, 0, 0));

		//act
		fecha = DateUtils.agregarHorasDate(DateUtils.convertirLocalDateTimeToDate(fechaCalculada), horasASumar);
		
		//assert
		assertThat(fecha.compareTo(fechaEsperadas), equalTo(0));
	}
	
	@Test
	public void debeConvertirCorrectamenteDesdeLocalDateTime() {
		//arrange
		Date fecha = new Date();
		Date fechaEsperada = fecha;
		//act
		fecha = DateUtils.convertirLocalDateTimeToDate(DateUtils.convertirDateToLocalDateTime(fecha));
		
		//assert
		assertThat(fecha.compareTo(fechaEsperada), equalTo(0));
	}
	
}
