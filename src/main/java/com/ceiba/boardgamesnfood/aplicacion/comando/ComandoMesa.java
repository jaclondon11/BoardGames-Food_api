package com.ceiba.boardgamesnfood.aplicacion.comando;

public class ComandoMesa {
	private Long id;
	private String codigo;

	public ComandoMesa() {
		super();
	}

	public ComandoMesa(String codigo) {
		super();
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}

}
