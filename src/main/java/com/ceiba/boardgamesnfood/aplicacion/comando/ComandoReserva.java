package com.ceiba.boardgamesnfood.aplicacion.comando;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ceiba.boardgamesnfood.dominio.JuegoType;

public class ComandoReserva {
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd-HH:mm:ss";

	@NotNull
	@Size(max = 100)
	private String titular;
	@NotNull
	private String game;
	@Min(value = 0)
	@Max(value = 10)
	private int numberPeople;
	@NotNull
	@DateTimeFormat(pattern = DATE_TIME_FORMAT)
	private Date reservationDate;
	
	public ComandoReserva(@NotNull @Size(max = 100) String titular, @NotNull String game,
			@Min(0) @Max(10) int numberPeople, @NotNull Date reservationDate) {
		super();
		this.titular = titular;
		this.game = game;
		this.numberPeople = numberPeople;
		this.reservationDate = reservationDate;
	}

	public ComandoReserva() {
		super();
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
