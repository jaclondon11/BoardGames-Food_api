package com.ceiba.boardgamesnfood.dominio.servicio.mesa;


import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;

@Component
public class ServicioCrearMesa {

	private RepositorioMesa repositorioMesa;

	public ServicioCrearMesa(RepositorioMesa repositorioMesa) {
		this.repositorioMesa = repositorioMesa;
	}

	public Table ejecutar(Table mesa) {
		return this.repositorioMesa.agregar(mesa);
	}
}
