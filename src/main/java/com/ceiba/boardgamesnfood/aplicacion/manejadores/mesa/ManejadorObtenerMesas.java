package com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;

@Component
public class ManejadorObtenerMesas {
	
	private final RepositorioMesa repositorioMesa;

	public ManejadorObtenerMesas(RepositorioMesa repositorioMesa) {
		this.repositorioMesa = repositorioMesa;
	}

	
	@Transactional
	public List<Table> ejecutar() {
		return this.repositorioMesa.obtenerMesas();
	}

}
