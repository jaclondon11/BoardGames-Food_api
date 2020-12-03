package com.ceiba.boardgamesnfood.aplicacion.manejadores.reserva;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.servicio.reserva.ServicioObtenerReserva;

@Component
public class ManejadorObtenerReserva {

    private final ServicioObtenerReserva servicioObtenerReserva;

    public ManejadorObtenerReserva(ServicioObtenerReserva servicioObtenerReserva) {
        this.servicioObtenerReserva = servicioObtenerReserva;
    }

    @Transactional
    public Reserva ejecutar(Long id) {
        return this.servicioObtenerReserva.ejecutar(id) ;
    }
}
