package com.ceiba.boardgamesnfood.infraestructura.controllador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.boardgamesnfood.aplicacion.manejadores.garantia.ManejadorGenerarReserva;
import com.ceiba.boardgamesnfood.aplicacion.manejadores.garantia.ManejadorObtenerReserva;
import com.ceiba.boardgamesnfood.dominio.Reserva;

@RestController
@RequestMapping("/reserva")
public class ControladorReserva {
	private final ManejadorObtenerReserva manejadorObtenerReserva;
	private final ManejadorGenerarReserva manejadorGenerarReserva;

	public ControladorReserva(ManejadorObtenerReserva manejadorObtenerGarantia,
			ManejadorGenerarReserva manejadorGenerarGarantia) {
		this.manejadorObtenerReserva = manejadorObtenerGarantia;
		this.manejadorGenerarReserva = manejadorGenerarGarantia;
	}

	@PostMapping("/{idProducto}/{nombreCliente}")
	public void generar(@PathVariable(name = "idProducto") String codigoProducto, 
						@PathVariable(name = "nombreCliente") String nombreCliente) {
		manejadorGenerarReserva.ejecutar(codigoProducto, nombreCliente);
	}

	@GetMapping("/{id}")
	public Reserva buscar(@PathVariable(name = "id") String id) {
		return this.manejadorObtenerReserva.ejecutar(id);
	}
}
