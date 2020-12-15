package com.ceiba.boardgamesnfood.dominio;

public enum JuegoType {

	CATAN("Catan", 2, 5, 90),
	EXPLODING_KITTENS("Exploding Kittens", 2, 10, 20),
	COUP("Coup", 2, 6, 15),
	ULTIMATE_WEREWOLF("Ultimate Werewolf", 7, 60, 20),
	TICKET_TO_RIDE_EUROPE("Ticket To Ride Europe", 2, 5, 90);
	
	public static JuegoType fromString(String value) {
        for (JuegoType juegoType : values()) {
            if (juegoType.gameName.equalsIgnoreCase(value)) {
                return juegoType;
            }
        }
        throw new IllegalArgumentException(value + " is not a JuegoType");
    }
	
	private final String gameName;
	private final int cantidadJugadoresMinima;
	private final int cantidadJugadoresMaxima;
	private final int duracionMediaMinutos;

	private JuegoType(String nombre, int cantidadJugadoresMinima, int cantidadJugadoresMaxima,
			int duracionMediaMinutos) {
		this.gameName = nombre;
		this.cantidadJugadoresMinima = cantidadJugadoresMinima;
		this.cantidadJugadoresMaxima = cantidadJugadoresMaxima;
		this.duracionMediaMinutos = duracionMediaMinutos;
	}

	public String getGameName() {
		return gameName;
	}

	public int getCantidadJugadoresMinima() {
		return cantidadJugadoresMinima;
	}

	public int getCantidadJugadoresMaxima() {
		return cantidadJugadoresMaxima;
	}

	public int getDuracionMediaMinutos() {
		return duracionMediaMinutos;
	}

}
