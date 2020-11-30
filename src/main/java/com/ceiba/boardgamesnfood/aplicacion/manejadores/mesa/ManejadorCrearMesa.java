package com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoMesa;
import com.ceiba.boardgamesnfood.aplicacion.fabrica.FabricaMesa;
import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.servicio.mesa.ServicioCrearMesa;

@Component
public class ManejadorCrearMesa {

	private final ServicioCrearMesa servicioCrearMesa;
	private final FabricaMesa fabricaMesa;

	public ManejadorCrearMesa(ServicioCrearMesa servicioCrearMesa, FabricaMesa fabricaMesa) {
		this.servicioCrearMesa = servicioCrearMesa;
		this.fabricaMesa = fabricaMesa;
	}

	@Transactional
	public void ejecutar(ComandoMesa comandoMesa) {
		Mesa mesa = this.fabricaMesa.crearMesa(comandoMesa);
		this.servicioCrearMesa.ejecutar(mesa);
	}
}
