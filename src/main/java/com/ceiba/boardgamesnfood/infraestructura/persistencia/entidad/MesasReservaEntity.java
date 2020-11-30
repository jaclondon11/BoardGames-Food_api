package com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MesasReserva")
public class MesasReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_MESA", referencedColumnName = "id")
	private MesaEntity mesa;

	@ManyToOne
	@JoinColumn(name = "ID_RESERVA", referencedColumnName = "id")
	private ReservaEntity reserva;

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
