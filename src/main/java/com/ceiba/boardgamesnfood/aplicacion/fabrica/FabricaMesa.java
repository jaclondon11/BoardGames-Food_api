package com.ceiba.boardgamesnfood.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoMesa;
import com.ceiba.boardgamesnfood.dominio.Mesa;

@Component
public class FabricaMesa {
	public Mesa crearMesa(ComandoMesa comandoMesa) {
		return new Mesa(comandoMesa.getCodigo());
	}
}
