package com.ceiba.boardgamesnfood.dominio.excepcion;

public class MesasDisponiblesNoEncontradasException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public static final String MENSAJE_MESAS_NO_DISPONIBLES = "No existen mesas disponibles para la fecha solicitada";
	
	public MesasDisponiblesNoEncontradasException() {
		super(String.format(MENSAJE_MESAS_NO_DISPONIBLES));
	}
}
