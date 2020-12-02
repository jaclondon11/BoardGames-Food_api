package com.ceiba.boardgamesnfood.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.dominio.servicio.vendedor.ServicioGenerarReserva;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioGenerarReserva servicioCrearUsuario(
			RepositorioMesasPorReserva repositorioMesasPorReserva,
			RepositorioReserva repositorioReserva) {
		return new ServicioGenerarReserva(repositorioMesasPorReserva, repositorioReserva);
	}
}
