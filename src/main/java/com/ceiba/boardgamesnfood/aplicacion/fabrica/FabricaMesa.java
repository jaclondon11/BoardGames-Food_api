package com.ceiba.boardgamesnfood.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoTable;
import com.ceiba.boardgamesnfood.dominio.Table;

@Component
public class FabricaMesa {
	public Table crearMesa(ComandoTable comandoMesa) {
		return new Table(comandoMesa.getCode());
	}
}
