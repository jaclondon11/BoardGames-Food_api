package com.ceiba.boardgamesnfood.aplicacion.comando;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ComandoTable {
	private Long id;
	
	@NotNull
	@Size(max = 100)
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
