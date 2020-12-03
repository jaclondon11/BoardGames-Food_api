package com.ceiba.boardgamesnfood.aplicacion.comando;


import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ceiba.boardgamesnfood.dominio.JuegoType;

public class ComandoReserva {

	@NotNull
	@Size(max = 100)
	private String titular;
	@NotNull
	private JuegoType juego;
	@Min(value = 0)
	@Max(value = 10)
	private int cantidadPersonas;
	@NotNull
	private Date fechaReserva;

	public ComandoReserva() {
		super();
	}

	public ComandoReserva(String titular, JuegoType juego, int cantidadPersonas, Date fechaReserva) {
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
