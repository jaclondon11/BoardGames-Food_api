package com.ceiba.boardgamesnfood.aplicacion.comando;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ComandoMesa {
	private Long id;
	
	@NotNull
	@Size(max = 100)
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
