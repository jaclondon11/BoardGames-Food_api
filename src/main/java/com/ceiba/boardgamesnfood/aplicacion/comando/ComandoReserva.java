package com.ceiba.boardgamesnfood.aplicacion.comando;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.ceiba.boardgamesnfood.dominio.JuegoType;

public class ComandoReserva {

	@NotNull
	private String titular;
	@NotNull
	private JuegoType juego;
	@Min(value = 0)
	private int cantidadPersonas;
	@NotNull
	private Date fechaReserva;

	public ComandoReserva() {
		super();
	}

	public ComandoReserva(@NotNull String titular, @NotNull JuegoType juego, @Min(0) int cantidadPersonas,
			@NotNull Date fechaReserva) {
		super();
		this.titular = titular;
		this.juego = juego;
		this.cantidadPersonas = cantidadPersonas;
		this.fechaReserva = fechaReserva;
	}

	public String getTitular() {
		return titular;
	}

	public JuegoType getJuego() {
		return juego;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

}
