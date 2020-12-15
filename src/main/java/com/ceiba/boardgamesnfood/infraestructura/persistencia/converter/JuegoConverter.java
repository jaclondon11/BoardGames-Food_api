package com.ceiba.boardgamesnfood.infraestructura.persistencia.converter;

import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.infraestructura.dominio.GameResponse;

public final class JuegoConverter {
	
	private JuegoConverter() {
		
	}
	
	public static GameResponse convertirADominio(JuegoType juego) {
		return new GameResponse(juego.name(), juego.getGameName());
	}
	

}
