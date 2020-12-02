package com.ceiba.boardgamesnfood.dominio;

import java.util.Date;
import java.util.List;

public class Reserva {

	private Long id;
	private List<MesasPorReserva> mesas;
	private Date fechaInicioReserva;
	private Date fechaFinReserva;
	private int cantidadPersonas;
	private String titular;
	private JuegoType juego;

	
	public Reserva() {
		super();
	}

	/*
	 * TODO 
	 * Arquitectura orientada al dominio
	 * 
	 * Leer modelo de dominios anemicos
	 */
	/**
	 * Full constructor
	 * @param id
	 * @param list
	 * @param fechaInicioReserva
	 * @param fechaFinReserva
	 * @param cantidadPersonas
	 * @param titular
	 * @param juego
	 */
	public Reserva(Long id, List<MesasPorReserva> mesas, Date fechaInicioReserva, Date fechaFinReserva, int cantidadPersonas,
			String titular, JuegoType juego) {
		super();
		this.id = id;
		this.mesas = mesas;
		this.fechaInicioReserva = fechaInicioReserva;
		this.fechaFinReserva = fechaFinReserva;
		this.cantidadPersonas = cantidadPersonas;
		this.titular = titular;
		this.juego = juego;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<MesasPorReserva> getMesas() {
		return mesas;
	}

	public void setMesas(List<MesasPorReserva> mesas) {
		this.mesas = mesas;
	}

}
