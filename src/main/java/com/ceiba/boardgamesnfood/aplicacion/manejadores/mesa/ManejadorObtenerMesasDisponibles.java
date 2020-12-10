package com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.dominio.Table;
import com.ceiba.boardgamesnfood.dominio.servicio.mesas_por_reserva.ServicioObtenerMesasDisponibles;

@Service
public class ManejadorObtenerMesasDisponibles {

	private final ServicioObtenerMesasDisponibles servicioObtenerMesasDisponibles;

	public ManejadorObtenerMesasDisponibles(ServicioObtenerMesasDisponibles servicioObtenerMesasDisponibles) {
		this.servicioObtenerMesasDisponibles = servicioObtenerMesasDisponibles;
	}

	@Transactional
	public List<Table> ejecutar(Date fechaHora) {
		return servicioObtenerMesasDisponibles.obtenerMesasDisponiblesByFecha(fechaHora);
	}
}
