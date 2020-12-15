package com.ceiba.boardgamesnfood.infraestructura.controllador;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoTable;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa.ManejadorCrearMesa;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa.ManejadorObtenerMesa;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa.ManejadorObtenerMesas;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa.ManejadorObtenerMesasDisponibles;
import com.ceiba.boardgamesnfood.dominio.Table;

@RestController
@RequestMapping("/api/mesa")
public class ControladorMesa {
		
		private final ManejadorCrearMesa manejadorCrearMesa;
		private final ManejadorObtenerMesa manejadorObtenerMesa;
		private final ManejadorObtenerMesasDisponibles manejadorObtenerMesasDisponibles;
		private final ManejadorObtenerMesas manejadorObtenerMesas;

	public ControladorMesa(ManejadorCrearMesa manejadorCrearMesa,
			ManejadorObtenerMesa manejadorObtenerMesa,
			ManejadorObtenerMesasDisponibles manejadorObtenerMesasDisponibles,
			ManejadorObtenerMesas manejadorObtenerMesas) {
		this.manejadorCrearMesa = manejadorCrearMesa;
		this.manejadorObtenerMesa = manejadorObtenerMesa;
		this.manejadorObtenerMesasDisponibles = manejadorObtenerMesasDisponibles;
		this.manejadorObtenerMesas = manejadorObtenerMesas;
	}

	@Valid
	@PutMapping
	public Table agregar(@RequestBody
			ComandoTable comandoMesa) {
		return this.manejadorCrearMesa.ejecutar(comandoMesa);
	}

	@GetMapping("/{codigo}")
	public Table buscar(@PathVariable(name = "codigo") String codigo) {
		return this.manejadorObtenerMesa.ejecutar(codigo);
	}
	
	@GetMapping("")
	public List<Table> obtenerMesas() {
		return this.manejadorObtenerMesas.ejecutar();
	}
	
	@GetMapping("/disponibles/{fechaHora}")
	public List<Table> obtenerMesasDisponibles(
			@PathVariable(name = "fechaHora")
			@DateTimeFormat(pattern = ComandoReserva.DATE_TIME_FORMAT)
			Date fecha) {
		return this.manejadorObtenerMesasDisponibles.ejecutar(fecha);
	}
}