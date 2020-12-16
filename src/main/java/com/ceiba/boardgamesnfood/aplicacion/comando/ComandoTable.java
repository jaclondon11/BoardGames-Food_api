package com.ceiba.boardgamesnfood.aplicacion.comando;

public class ComandoTable {
	private Long id;
	private String code;

	public ComandoTable() {
		super();
	}

	public ComandoTable(String codigo) {
		super();
		this.code = codigo;
	}

	public String getCode() {
		return code;
	}

	public Long getId() {
		return id;
	}

}
