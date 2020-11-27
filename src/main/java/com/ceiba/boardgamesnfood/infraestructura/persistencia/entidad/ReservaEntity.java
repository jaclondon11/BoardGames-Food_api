package com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.ceiba.boardgamesnfood.dominio.JuegoType;

@Entity(name = "Reserva")
@NamedQuery(name = "Reserva.findById", query = "SELECT reserva from Reserva reserva where reserva.id = :id")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_MESA", referencedColumnName = "id")
	private MesaEntity mesa;

	private Date fechaReserva;

	private int cantidadPersonas;

	private String titular;

	private JuegoType juego;

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

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public JuegoType getJuego() {
		return juego;
	}

	public void setJuego(JuegoType juego) {
		this.juego = juego;
	}

}
