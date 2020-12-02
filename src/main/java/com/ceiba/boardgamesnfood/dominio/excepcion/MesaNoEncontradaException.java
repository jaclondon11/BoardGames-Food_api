package com.ceiba.boardgamesnfood.dominio.excepcion;

public class MesaNoEncontradaException extends RuntimeException {
	
	public static final String MESA_NO_ENCONTRADA = "La mesa con codigo '%s', no existe";

	private static final long serialVersionUID = 1L;
	
	public MesaNoEncontradaException(String codigo) {
		super(String.format(MESA_NO_ENCONTRADA, codigo));
	}
}
