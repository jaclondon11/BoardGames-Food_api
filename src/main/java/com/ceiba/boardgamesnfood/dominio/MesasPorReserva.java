package com.ceiba.boardgamesnfood.dominio;

public class MesasPorReserva {

	private Long id;
	private Mesa mesa;
	private Reserva reserva;

	public MesasPorReserva(Long id, Mesa mesa, Reserva reserva) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.reserva = reserva;
	}

	public Long getId() {
		return id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public Reserva getReserva() {
		return reserva;
	}
}
