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
	
	/**
	 * 
	 * @param id
	 */
	public Reserva(Long id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 * @param fechaInicioReserva
	 * @param cantidadPersonas
	 * @param titular
	 * @param juego
	 */
	public Reserva(Date fechaInicioReserva, int cantidadPersonas, String titular, JuegoType juego) {
		super();
		this.fechaInicioReserva = fechaInicioReserva;
		this.cantidadPersonas = cantidadPersonas;
		this.titular = titular;
		this.juego = juego;
	}

	/**
	 * Full constructor
	 * 
	 * @param id
	 * @param list
	 * @param fechaInicioReserva
	 * @param fechaFinReserva
	 * @param cantidadPersonas
	 * @param titular
	 * @param juego
	 */
	public Reserva(Long id, List<MesasPorReserva> mesas, Date fechaInicioReserva, Date fechaFinReserva,
			int cantidadPersonas, String titular, JuegoType juego) {
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

	public List<MesasPorReserva> getMesas() {
		return mesas;
	}

	public Date getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public Date getFechaFinReserva() {
		return fechaFinReserva;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public String getTitular() {
		return titular;
	}

	public JuegoType getJuego() {
		return juego;
	}

}
