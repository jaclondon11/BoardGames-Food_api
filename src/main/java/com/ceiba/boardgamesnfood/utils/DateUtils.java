package com.ceiba.boardgamesnfood.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	
	private DateUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Date convertirLocalDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.toInstant(OffsetDateTime.now().getOffset()));
	}
	
	public static LocalDateTime convertirDateToLocalDateTime(Date fecha) {
		return fecha.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
	}

	public static Date agregarHorasDate(Date fechaInicioReserva, int horasASumar) {
		LocalDateTime fechaFinReserva = convertirDateToLocalDateTime(fechaInicioReserva);
		return convertirLocalDateTimeToDate(fechaFinReserva.plusHours(horasASumar));
	}
	

}
