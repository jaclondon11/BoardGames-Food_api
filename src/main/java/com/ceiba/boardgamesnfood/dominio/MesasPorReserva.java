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

	public void setId(Long id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
