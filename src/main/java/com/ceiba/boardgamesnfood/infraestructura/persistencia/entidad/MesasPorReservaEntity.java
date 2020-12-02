package com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "MesasPorReserva")
@Table(name = "MESAS_POR_RESERVA")
@NamedQuery(name = "MesasPorReserva.findMesasConReservas",
		query = "SELECT m.id FROM Mesa m "
				+ "LEFT JOIN MesasPorReserva mr on mr.mesa.id = m.id "
				+ "WHERE :fechaInicioReserva BETWEEN mr.reserva.fechaInicioReserva AND mr.reserva.fechaFinReserva")
public class MesasPorReservaEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MESA", referencedColumnName = "id")
	private MesaEntity mesa;

	@ManyToOne(fetch = FetchType.LAZY)
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
