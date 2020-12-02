package com.ceiba.boardgamesnfood.infraestructura.controllador;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoMesa;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa.ManejadorCrearMesa;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa.ManejadorObtenerMesa;
import com.ceiba.boardgamesnfood.dominio.Mesa;

@RestController
@RequestMapping("/mesa")
public class ControladorMesa {
		private final ManejadorCrearMesa manejadorCrearMesa;
		private final ManejadorObtenerMesa manejadorObtenerMesa;

	public ControladorMesa(ManejadorCrearMesa manejadorCrearMesa, ManejadorObtenerMesa manejadorObtenerMesa) {
		this.manejadorCrearMesa = manejadorCrearMesa;
		this.manejadorObtenerMesa = manejadorObtenerMesa;
	}

	@Valid
	@PostMapping
	public void agregar(@RequestBody
			ComandoMesa comandoMesa) {
		this.manejadorCrearMesa.ejecutar(comandoMesa);
	}

	@GetMapping("/{codigo}")
	public Mesa buscar(@PathVariable(name = "codigo") String codigo) {
		return this.manejadorObtenerMesa.ejecutar(codigo);
		
	}
}