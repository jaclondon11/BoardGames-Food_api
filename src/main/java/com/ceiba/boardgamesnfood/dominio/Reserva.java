package com.ceiba.boardgamesnfood.dominio;

import java.util.Date;
import java.util.List;

public class Reserva {

	private Long id;
	private List<MesasPorReserva> mesas;
	private Date startReservationDate;
	private Date endReservationDate;
	private int numberPeople;
	private String titular;
	private JuegoType game;

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
	 * @param startReservationDate
	 * @param numberPeople
	 * @param titular
	 * @param game
	 */
	public Reserva(Date startReservationDate, int numberPeople, String titular, JuegoType game) {
		super();
		this.startReservationDate = startReservationDate;
		this.numberPeople = numberPeople;
		this.titular = titular;
		this.game = game;
	}

	/**
	 * Full constructor
	 * @param id
	 * @param mesas
	 * @param startReservationDate
	 * @param endReservationDate
	 * @param numberPeople
	 * @param titular
	 * @param game
	 */
	public Reserva(Long id, List<MesasPorReserva> mesas, Date startReservationDate, Date endReservationDate,
			int numberPeople, String titular, JuegoType game) {
		super();
		this.id = id;
		this.mesas = mesas;
		this.startReservationDate = startReservationDate;
		this.endReservationDate = endReservationDate;
		this.numberPeople = numberPeople;
		this.titular = titular;
		this.game = game;
	}
	
	public Long getId() {
		return id;
	}

	public List<MesasPorReserva> getMesas() {
		return mesas;
	}

	public Date getFechaInicioReserva() {
		return startReservationDate;
	}

	public Date getFechaFinReserva() {
		return endReservationDate;
	}

	public int getCantidadPersonas() {
		return numberPeople;
	}

	public String getTitular() {
		return titular;
	}

	public JuegoType getJuego() {
		return game;
	}

}
