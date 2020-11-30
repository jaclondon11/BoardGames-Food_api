package com.ceiba.boardgamesnfood.dominio.excepcion;

public class MesaNoEncontradaException extends RuntimeException {
	
	public static final String PRODUCTO_NO_ENCONTRADO = "El producto con codigo '%s', no existe";

	private static final long serialVersionUID = 1L;
	
	public MesaNoEncontradaException(String codigo) {
		super(String.format(PRODUCTO_NO_ENCONTRADO, codigo));
	}
}
