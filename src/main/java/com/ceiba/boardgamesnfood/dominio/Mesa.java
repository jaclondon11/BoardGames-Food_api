package com.ceiba.boardgamesnfood.dominio;

public class Mesa {
	private Long id;
	private String codigo;

	public Mesa(Long id, String codigo) {
		this.id = id;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}

}
