package com.ceiba.boardgamesnfood.aplicacion.manejadores.reserva;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.servicio.vendedor.ServicioGenerarReserva;

@Component
public class ManejadorGenerarReserva {
	
	private final ServicioGenerarReserva servicioGenerarReserva;

	public ManejadorGenerarReserva(ServicioGenerarReserva servicioGenerarVendedor) {
		this.servicioGenerarReserva = servicioGenerarVendedor;
	}
	
	/*
	 * TODO
	 * usar la fabrica para enviar un dto al servicio
	 */
	@Transactional
	public void ejecutar(ComandoReserva comandoReserva) {
		this.servicioGenerarReserva.generarReserva(comandoReserva);
	}
	
	
	
}
