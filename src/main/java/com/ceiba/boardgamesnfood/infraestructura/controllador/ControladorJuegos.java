package com.ceiba.boardgamesnfood.infraestructura.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.boardgamesnfood.aplicacion.manejadores.juego.ManejadorObtenerJuegosDisponibles;
import com.ceiba.boardgamesnfood.dominio.JuegoType;

@RestController
@RequestMapping("/api/juegos")
public class ControladorJuegos {
	
	private final ManejadorObtenerJuegosDisponibles manejadorObtenerJuegosDisponibles;
	
	@Autowired
	public ControladorJuegos(ManejadorObtenerJuegosDisponibles manejadorObtenerJuegosDisponibles) {
		super();
		this.manejadorObtenerJuegosDisponibles = manejadorObtenerJuegosDisponibles;
	}

	@GetMapping("")
	public JuegoType[] obtenerJuegosDisponibles() {
		return this.manejadorObtenerJuegosDisponibles.ejecutar();
	}
	
	

}
