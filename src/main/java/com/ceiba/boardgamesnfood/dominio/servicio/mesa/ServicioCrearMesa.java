package com.ceiba.boardgamesnfood.dominio.servicio.mesa;


import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;

@Component
public class ServicioCrearMesa {

	private RepositorioMesa repositorioMesa;

	public ServicioCrearMesa(RepositorioMesa repositorioMesa) {
		this.repositorioMesa = repositorioMesa;
	}

	public void ejecutar(Mesa producto) {
		this.repositorioMesa.agregar(producto);
	}
}
