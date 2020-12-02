package com.ceiba.boardgamesnfood.infraestructura.persistencia.builder;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;

public class MesasPorReservaBuilder {

	private Mesa mesa;
	private Reserva reserva;
	
	public static MesasPorReservaBuilder build() {
		return new MesasPorReservaBuilder();
	}

	private MesasPorReservaBuilder() {
		super();
	}

	public MesasPorReservaBuilder conMesa(Mesa mesa) {
		this.mesa = mesa;
		return this;
	}
	
	public MesasPorReservaBuilder conReserva(Reserva reserva) {
		this.reserva = reserva;
		return this;
	}

	public MesasPorReserva getResult() {
		return new MesasPorReserva(null, this.mesa, this.reserva);
	}

	
}
