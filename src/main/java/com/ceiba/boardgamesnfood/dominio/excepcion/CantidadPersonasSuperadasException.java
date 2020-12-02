package com.ceiba.boardgamesnfood.dominio.excepcion;

public class CantidadPersonasSuperadasException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final String MENSAJE_CANTIDAD_PERSONAS_SUPERADAS = 
			"La reserva supera la cantidad maxima de personas para el juego solicitado";
	
	public CantidadPersonasSuperadasException() {
		super(String.format(MENSAJE_CANTIDAD_PERSONAS_SUPERADAS));
	}
}
