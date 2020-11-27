package com.ceiba.boardgamesnfood.dominio.servicio.producto;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;

@Component
public class ServicioObtenerProducto {

	private RepositorioProducto repositorioProducto;

	public ServicioObtenerProducto(RepositorioProducto repositorioProducto) {
		this.repositorioProducto = repositorioProducto;
	}

	public Mesa ejecutar(String codigo) {
		return this.repositorioProducto.obtenerPorCodigo(codigo);
	}
}
