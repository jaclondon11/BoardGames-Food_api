package com.ceiba.boardgamesnfood.dominio.servicio.mesa;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;

@Component
public class ServicioObtenerMesa {

	private RepositorioMesa repositorioMesa;

	public ServicioObtenerMesa(RepositorioMesa repositorioMesa) {
		this.repositorioMesa = repositorioMesa;
	}

	public Table ejecutar(String codigo) {
		return this.repositorioMesa.obtenerPorCodigo(codigo);
	}
}
