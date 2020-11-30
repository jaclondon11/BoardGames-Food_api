package com.ceiba.boardgamesnfood.dominio.unitaria;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.testdatabuilder.MesaTestDataBuilder;

public class MesaTest {

	private static final String CODIGO = "1";

	@Test
	public void crearProductoTest() {
		
		// arrange
		MesaTestDataBuilder mesaTestDataBuilder = new MesaTestDataBuilder().
				conCodigo(CODIGO);

		// act
		Mesa mesa = mesaTestDataBuilder.build();

		// assert
		assertEquals(CODIGO, mesa.getCodigo());
	}

}
