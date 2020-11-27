package com.ceiba.boardgamesnfood.dominio;

import java.util.Date;

public class Reserva {

	private Mesa mesa;
	private Date fechaReserva;
	private int cantidadPersonas;
	private String titular;
	private JuegoType juego;

	public Reserva() {
		super();
	}

	/**
	 * Full Constructor
	 * @param mesa
	 * @param fechaReserva
	 * @param cantidadPersonas
	 * @param titular
	 * @param juego
	 */
	public Reserva(Mesa mesa, Date fechaReserva, int cantidadPersonas, String titular, JuegoType juego) {
		super();
		this.mesa = mesa;
		this.fechaReserva = fechaReserva;
		this.cantidadPersonas = cantidadPersonas;
		this.titular = titular;
		this.juego = juego;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public JuegoType getJuego() {
		return juego;
	}

	public void setJuego(JuegoType juego) {
		this.juego = juego;
	}

}
