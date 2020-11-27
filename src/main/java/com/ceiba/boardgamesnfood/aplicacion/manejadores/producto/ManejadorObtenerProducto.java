package com.ceiba.boardgamesnfood.aplicacion.manejadores.producto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.servicio.producto.ServicioObtenerProducto;

@Service
public class ManejadorObtenerProducto {

	private final ServicioObtenerProducto servicioObtenerProducto;

	public ManejadorObtenerProducto(ServicioObtenerProducto servicioObtenerProducto) {
		this.servicioObtenerProducto = servicioObtenerProducto;
	}

	@Transactional
	public Mesa ejecutar(String codigo) {
	 return	this.servicioObtenerProducto.ejecutar(codigo);
	}
}
