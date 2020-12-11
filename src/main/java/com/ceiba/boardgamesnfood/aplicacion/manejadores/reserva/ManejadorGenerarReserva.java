package com.ceiba.boardgamesnfood.aplicacion.manejadores.reserva;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva.ServicioObtenerMesasDisponibles;
import com.ceiba.boardgamesnfood.dominio.servicio.reserva.ServicioGenerarReserva;

@Component
public class ManejadorGenerarReserva {
	
	private final ServicioGenerarReserva servicioGenerarReserva;
	private final ServicioObtenerMesasDisponibles servicioObtenerMesasDisponibles;

	public ManejadorGenerarReserva(
			ServicioGenerarReserva servicioGenerarVendedor,
			ServicioObtenerMesasDisponibles servicioObtenerMesasDisponibles) {
		this.servicioGenerarReserva = servicioGenerarVendedor;
		this.servicioObtenerMesasDisponibles = servicioObtenerMesasDisponibles;
		
	}
	
	@Transactional
	public Reserva ejecutar(ComandoReserva comandoReserva) {
		Reserva prospectoReserva = new Reserva(
				comandoReserva.getFechaReserva(),
				comandoReserva.getCantidadPersonas(),
				comandoReserva.getTitular(),
				comandoReserva.getJuego());
		
		List<Table> mesas = servicioObtenerMesasDisponibles
				.obtenerMesasDisponiblesByFecha(prospectoReserva.getFechaInicioReserva());
		
		return this.servicioGenerarReserva.generarReserva(prospectoReserva, mesas);
	}
	
	
	
}
