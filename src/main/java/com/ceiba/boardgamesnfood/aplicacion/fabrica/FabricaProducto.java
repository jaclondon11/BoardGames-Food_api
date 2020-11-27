package com.ceiba.boardgamesnfood.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoProducto;
import com.ceiba.boardgamesnfood.dominio.Mesa;

@Component
public class FabricaProducto {
	public Mesa crearProducto(ComandoProducto comandoProducto) {
		return new Mesa(comandoProducto.getId(),
				comandoProducto.getCodigo(),
				comandoProducto.getNombre(),
				comandoProducto.getPrecio());
	}
}
