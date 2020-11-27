package com.ceiba.boardgamesnfood.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;
import com.ceiba.boardgamesnfood.dominio.servicio.vendedor.ServicioVendedor;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioVendedor servicioCrearUsuario(RepositorioProducto repositorioProducto, RepositorioReserva repositorioGarantiaExtendida) {
		return new ServicioVendedor(repositorioProducto, repositorioGarantiaExtendida);
	}
}
