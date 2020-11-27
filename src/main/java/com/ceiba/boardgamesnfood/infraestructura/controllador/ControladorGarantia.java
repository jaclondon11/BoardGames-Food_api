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
@RequestMapping("/garantia")
public class ControladorGarantia {
	private final ManejadorObtenerReserva manejadorObtenerGarantia;
	private final ManejadorGenerarReserva manejadorGenerarGarantia;

	public ControladorGarantia(ManejadorObtenerReserva manejadorObtenerGarantia,
			ManejadorGenerarReserva manejadorGenerarGarantia) {
		this.manejadorObtenerGarantia = manejadorObtenerGarantia;
		this.manejadorGenerarGarantia = manejadorGenerarGarantia;
	}

	@PostMapping("/{idProducto}/{nombreCliente}")
	public void generar(@PathVariable(name = "idProducto") String codigoProducto, 
						@PathVariable(name = "nombreCliente") String nombreCliente) {
		manejadorGenerarGarantia.ejecutar(codigoProducto, nombreCliente);
	}

	@GetMapping("/{id}")
	public Reserva buscar(@PathVariable(name = "id") String codigo) {
		return this.manejadorObtenerGarantia.ejecutar(codigo);
	}
}
