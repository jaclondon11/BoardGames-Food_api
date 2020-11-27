package com.ceiba.boardgamesnfood.infraestructura.controllador;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoProducto;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.producto.ManejadorCrearProducto;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.producto.ManejadorObtenerProducto;
import com.ceiba.boardgamesnfood.dominio.Mesa;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
		private final ManejadorCrearProducto manejadorCrearProducto;
		private final ManejadorObtenerProducto manejadorObtenerProducto;

	public ControladorProducto(ManejadorCrearProducto manejadorCrearProducto, ManejadorObtenerProducto manejadorObtenerProducto) {
		this.manejadorCrearProducto = manejadorCrearProducto;
		this.manejadorObtenerProducto = manejadorObtenerProducto;
	}

	@Valid
	@PostMapping
	public void agregar(@RequestBody
			ComandoProducto comandoProducto) {
		this.manejadorCrearProducto.ejecutar(comandoProducto);
	}

	@GetMapping("/{id}")
	public Mesa buscar(@PathVariable(name = "id") String codigo) {
		return this.manejadorObtenerProducto.ejecutar(codigo);
	}
}
