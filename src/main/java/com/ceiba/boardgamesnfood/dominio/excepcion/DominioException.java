package com.ceiba.boardgamesnfood.dominio.excepcion;

public class DominioException extends RuntimeException{
	
	public enum ERRORES_DOMINIO{
		EMPTY("campo vacio o nulo"),
		RANGE("valor fuera del rango valido %s");

		private String detalle;
		
		private ERRORES_DOMINIO(String detalle) {
			this.detalle = detalle;
		}

		public String getDetalle() {
			return detalle;
		}

	}

	private static final long serialVersionUID = 1L;
	
	public static final String MENSAJE_GENERICO = 
			"Ocurrio un error en el dominio con el atributo %s, %s";
	
	public DominioException(String atributo, ERRORES_DOMINIO detalleError) {
		super(String.format(MENSAJE_GENERICO, atributo, detalleError.getDetalle()));
	}
	
	public DominioException(String atributo, ERRORES_DOMINIO detalleError, String rango) {
		super(String.format(String.format(MENSAJE_GENERICO, atributo, detalleError.getDetalle()), rango));
	}
	
}
