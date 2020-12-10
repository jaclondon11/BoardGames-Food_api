package com.ceiba.boardgamesnfood.testdatabuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoTable;
import com.ceiba.boardgamesnfood.dominio.Table;

public class MesaTestDataBuilder {

	private static final String CODIGO_DEFAULT = "NUEVO_CODIGO";

	private String codigo;

	public MesaTestDataBuilder() {
		this.codigo = CODIGO_DEFAULT;
	}

	public MesaTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public MesaTestDataBuilder conId(Long id) {
		return this;
	}
	
	public Table build() {
		return new Table(this.codigo);
	}

	public ComandoTable buildComando() {
		return new ComandoTable(this.codigo);
	}
	
	public static List<Table> defaultTestMesasList(){
		List<Table> mesasList = new ArrayList<>();
		LongStream.range(1, 6)
		.forEach(i -> mesasList.add(new Table(i, Long.toString(i))));
		return mesasList;
	}
}
