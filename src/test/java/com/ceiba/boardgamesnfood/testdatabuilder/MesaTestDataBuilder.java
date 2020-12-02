package com.ceiba.boardgamesnfood.testdatabuilder;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoMesa;
import com.ceiba.boardgamesnfood.dominio.Mesa;

public class MesaTestDataBuilder {

	private static final String CODIGO = "1";

	private String codigo;

	public MesaTestDataBuilder() {
		this.codigo = CODIGO;
	}

	public MesaTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public Mesa build() {
		return new Mesa(null, this.codigo);
	}

	public ComandoMesa buildComando() {
		return new ComandoMesa(this.codigo);
	}
}
