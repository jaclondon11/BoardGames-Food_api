package com.ceiba.boardgamesnfood.aplicacion.manejadores.juego;

import org.springframework.stereotype.Service;

import com.ceiba.boardgamesnfood.dominio.JuegoType;

@Service
public class ManejadorObtenerJuegosDisponibles {

	public JuegoType[] ejecutar() {
		return JuegoType.values();
	}

}
