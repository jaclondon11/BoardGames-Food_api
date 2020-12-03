package com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.servicio.mesa.ServicioObtenerMesa;

@Service
public class ManejadorObtenerMesa {

	private final ServicioObtenerMesa servicioObtenerMesa;

	public ManejadorObtenerMesa(ServicioObtenerMesa servicioObtenerMesa) {
		this.servicioObtenerMesa = servicioObtenerMesa;
	}

	@Transactional
	public Mesa ejecutar(String codigo) {
	 return	this.servicioObtenerMesa.ejecutar(codigo);
	}
}
