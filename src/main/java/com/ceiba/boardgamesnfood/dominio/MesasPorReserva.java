package com.ceiba.boardgamesnfood.dominio;

public class MesasPorReserva {

	private Long id;
	private Table mesa;
	private Reserva reserva;

	public MesasPorReserva(Long id, Table mesa, Reserva reserva) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.reserva = reserva;
	}

	public Long getId() {
		return id;
	}

	public Table getMesa() {
		return mesa;
	}

	public Reserva getReserva() {
		return reserva;
	}
}
