package com.ceiba.boardgamesnfood.aplicacion.comando;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ComandoReserva {
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd-HH:mm:ss";

	private String titular;
	private String game;
	private int numberPeople;
	@JsonFormat(pattern = DATE_TIME_FORMAT)
	private Date reservationDate;
	
	public ComandoReserva() {
		super();
	}
	
	public ComandoReserva(String titular, String game, int numberPeople, Date reservationDate) {
		super();
		this.titular = titular;
		this.game = game;
		this.numberPeople = numberPeople;
		this.reservationDate = reservationDate;
	}

	public String getTitular() {
		return titular;
	}

	public String getGame() {
		return game;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

}
