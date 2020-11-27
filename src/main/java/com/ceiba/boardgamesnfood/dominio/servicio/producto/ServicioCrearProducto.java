package com.ceiba.boardgamesnfood.dominio.servicio.producto;


import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;

@Component
public class ServicioCrearProducto {

	private RepositorioProducto repositorioProducto;

	public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
		this.repositorioProducto = repositorioProducto;
	}

	public void ejecutar(Mesa producto) {
		this.repositorioProducto.agregar(producto);
	}
}
