package com.ceiba.boardgamesnfood.dominio;

import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.ReservaEntity;

public class MesasReserva {

	private Long id;
	private MesaEntity mesa;
	private ReservaEntity reserva;

	public MesasReserva(Long id, MesaEntity mesa, ReservaEntity reserva) {
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

	public MesaEntity getMesa() {
		return mesa;
	}

	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}

	public ReservaEntity getReserva() {
		return reserva;
	}

	public void setReserva(ReservaEntity reserva) {
		this.reserva = reserva;
	}

}
