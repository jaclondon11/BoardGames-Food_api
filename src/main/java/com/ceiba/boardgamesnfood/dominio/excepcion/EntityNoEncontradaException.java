package com.ceiba.boardgamesnfood.dominio.excepcion;

public class EntityNoEncontradaException extends RuntimeException {
	
	public static final String ENTIDAD_NO_ENCONTRADA = "La entidad con codigo '%s', no existe";

	private static final long serialVersionUID = 1L;
	
	public EntityNoEncontradaException(String codigo) {
		super(String.format(ENTIDAD_NO_ENCONTRADA, codigo));
	}
}
