package com.ceiba.boardgamesnfood.testdatabuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoMesa;
import com.ceiba.boardgamesnfood.dominio.Mesa;

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
	
	public Mesa build() {
		return new Mesa(this.codigo);
	}

	public ComandoMesa buildComando() {
		return new ComandoMesa(this.codigo);
	}
	
	public static List<Mesa> defaultTestMesasList(){
		List<Mesa> mesasList = new ArrayList<>();
		LongStream.range(1, 6)
		.forEach(i -> mesasList.add(new Mesa(i, Long.toString(i))));
		return mesasList;
	}
}
