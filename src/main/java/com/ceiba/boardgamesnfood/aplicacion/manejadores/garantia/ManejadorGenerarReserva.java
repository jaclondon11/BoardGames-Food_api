package com.ceiba.boardgamesnfood.aplicacion.manejadores.garantia;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.servicio.vendedor.ServicioVendedor;

@Component
public class ManejadorGenerarReserva {
	
	private final ServicioVendedor servicioVendedor;

	public ManejadorGenerarReserva(ServicioVendedor servicioVendedor) {
		this.servicioVendedor = servicioVendedor;
	}
	
	@Transactional
	public void ejecutar(ComandoReserva comandoReserva) {
		this.servicioVendedor.generarGarantia(comandoReserva);
	}
	
	
	
}
