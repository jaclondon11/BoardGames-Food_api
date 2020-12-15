package com.ceiba.boardgamesnfood.testdatabuilder;

import java.util.Date;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.dominio.Reserva;

public class ReservaTestDataBuilder {


	private Date fechaInicioReserva;
	private int cantidadPersonas;
	private String titular;
	private JuegoType juego;

	public static ReservaTestDataBuilder build() {
		return new ReservaTestDataBuilder ();
	}
	
	private ReservaTestDataBuilder() {
		super();
	}

	public ReservaTestDataBuilder conFecha(Date fechaInicioReserva) {
		this.fechaInicioReserva = fechaInicioReserva;
		return this;
	}

	public ReservaTestDataBuilder conCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
		return this;
	}
	
	public ReservaTestDataBuilder conTitular(String titular) {
		this.titular = titular;
		return this;
	}
	
	public ReservaTestDataBuilder conJuego(JuegoType juego) {
		this.juego = juego;
		return this;
	}
	
	public Reserva getResult() {
		return new Reserva(fechaInicioReserva, cantidadPersonas, titular, juego);
	}
	
	public ComandoReserva getComando() {
		return new ComandoReserva(titular, juego.toString(), cantidadPersonas, fechaInicioReserva);
	}


}
