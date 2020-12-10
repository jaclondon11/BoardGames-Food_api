package com.ceiba.boardgamesnfood.aplicacion.manejadores.mesa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoTable;
import com.ceiba.boardgamesnfood.aplicacion.fabrica.FabricaMesa;
import com.ceiba.boardgamesnfood.dominio.Table;
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
	public void ejecutar(ComandoTable comandoMesa) {
		Table mesa = this.fabricaMesa.crearMesa(comandoMesa);
		this.servicioCrearMesa.ejecutar(mesa);
	}
}
