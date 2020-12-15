package com.ceiba.boardgamesnfood.infraestructura.dominio;

public class GameResponse {

	private final String gameKey;
	private final String gameName;

	public GameResponse(String gameKey, String gameName) {
		super();
		this.gameKey = gameKey;
		this.gameName = gameName;
	}

	public String getGameKey() {
		return gameKey;
	}

	public String getGameName() {
		return gameName;
	}

}
