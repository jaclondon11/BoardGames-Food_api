package com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.ceiba.boardgamesnfood.dominio.JuegoType;

@Entity(name = "Reserva")
@NamedQuery(name = "Reserva.findById", query = "SELECT reserva from Reserva reserva where reserva.id = :id")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date fechaInicioReserva;
	
	private Date fechaFinReserva;

	private int cantidadPersonas;

	private String titular;

	@Enumerated(EnumType.STRING)
	private JuegoType juego;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			mappedBy = "reserva",
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	private List<MesasPorReservaEntity> mesasReserva;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaInicioReserva() {
		return fechaInicioReserva;
	}

	public void setFechaInicioReserva(Date fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
	}

	public Date getFechaFinReserva() {
		return fechaFinReserva;
	}

	public void setFechaFinReserva(Date fechaFinReserva) {
		this.fechaFinReserva = fechaFinReserva;
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
	
	public void setMesas(List<MesasPorReservaEntity> mesasReserva) {
		this.mesasReserva = mesasReserva;
	}

	public List<MesasPorReservaEntity> getMesasReserva() {
		return mesasReserva;
	}

}
