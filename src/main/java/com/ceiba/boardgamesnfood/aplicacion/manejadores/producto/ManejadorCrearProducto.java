package com.ceiba.boardgamesnfood.aplicacion.manejadores.producto;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoProducto;
import com.ceiba.boardgamesnfood.aplicacion.fabrica.FabricaProducto;
import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.servicio.producto.ServicioCrearProducto;

@Component
public class ManejadorCrearProducto {

	private final ServicioCrearProducto servicioCrearProducto;
	private final FabricaProducto fabricaProducto;

	public ManejadorCrearProducto(ServicioCrearProducto servicioCrearProducto, FabricaProducto fabricaProducto) {
		this.servicioCrearProducto = servicioCrearProducto;
		this.fabricaProducto = fabricaProducto;
	}

	@Transactional
	public void ejecutar(ComandoProducto comandoProducto) {
		Mesa producto = this.fabricaProducto.crearProducto(comandoProducto);
		this.servicioCrearProducto.ejecutar(producto);
	}
}
