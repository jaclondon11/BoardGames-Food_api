package com.ceiba.boardgamesnfood.dominio;

import java.util.Date;
import java.util.Set;

public class Reserva {

	private Set<MesasReserva> mesas;
	private Date fechaInicioReserva;
	private Date fechaFinReserva;
	private int cantidadPersonas;
	private String titular;
	private JuegoType juego;

	public Reserva() {
		super();
	}

	public Reserva(Set<MesasReserva> mesas, Date fechaInicioReserva, Date fechaFinReserva, int cantidadPersonas,
			String titular, JuegoType juego) {
		super();
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaFinReserva = fechaFinReserva;
		this.cantidadPersonas = cantidadPersonas;
		this.titular = titular;
		this.juego = juego;
		this.mesas = mesas;
	}

	public Date getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public void setFechaInicioReserva(Date fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
	}

	public Date getFechaFinReserva() {
		return fechaFinReserva;
	}

	public void setFechaFinReserva(Date fechaFinReserva) {
		this.fechaFinReserva = fechaFinReserva;
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

	public Set<MesasReserva> getMesas() {
		return mesas;
	}

	public void setMesas(Set<MesasReserva> mesas) {
		this.mesas = mesas;
	}

}
