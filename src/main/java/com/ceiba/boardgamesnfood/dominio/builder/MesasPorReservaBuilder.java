package com.ceiba.boardgamesnfood.dominio.builder;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.MesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;

public class MesasPorReservaBuilder {

	private Table mesa;
	private Reserva reserva;
	
	public static MesasPorReservaBuilder build() {
		return new MesasPorReservaBuilder();
	}

	private MesasPorReservaBuilder() {
		super();
	}

	public MesasPorReservaBuilder conMesa(Table mesa) {
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
