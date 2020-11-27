package com.ceiba.boardgamesnfood.dominio.excepcion;

public class GarantiaCodigoProductoPorVocalesException extends RuntimeException {
	
	public static final String ESTE_PRODUCTO_NO_CUENTA_CON_GARANTIA = "Este producto no cuenta con garanti� extendida";

	private static final long serialVersionUID = 1L;
	
	public GarantiaCodigoProductoPorVocalesException() {
		super(String.format(ESTE_PRODUCTO_NO_CUENTA_CON_GARANTIA));
	}
}
