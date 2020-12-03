package com.ceiba.boardgamesnfood.dominio.servicio.reserva;

import org.springframework.stereotype.Component;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;

@Component
public class ServicioObtenerReserva {
    private RepositorioReserva repositorioReserva;

    public ServicioObtenerReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva ejecutar(Long id) {
        return this.repositorioReserva.obtener(id);
    }
}
