package com.ceiba.boardgamesnfood.aplicacion.manejadores.garantia;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.servicio.garantia.ServicioObtenerReserva;

@Component
public class ManejadorObtenerReserva {

    private final ServicioObtenerReserva servicioObtenerReserva;

    public ManejadorObtenerReserva(ServicioObtenerReserva servicioObtenerReserva) {
        this.servicioObtenerReserva = servicioObtenerReserva;
    }

    @Transactional
    public Reserva ejecutar(String id) {
        return this.servicioObtenerReserva.ejecutar(id) ;
    }
}
