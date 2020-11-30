package com.ceiba.boardgamesnfood.dominio.servicio.vendedor;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;

public class ServicioVendedor {


	@SuppressWarnings("unused")
	private RepositorioMesa repositorioMesa;
	private RepositorioReserva repositorioGarantia;

	public ServicioVendedor(RepositorioMesa repositorioMesa,
			RepositorioReserva repositorioReserva) {
		this.repositorioMesa = repositorioMesa;
		this.repositorioGarantia = repositorioReserva;
	}

	public void generarGarantia(ComandoReserva comandoReserva) {
		repositorioGarantia.agregar(null);
	}

	
//	public Reserva crearGarantiaExtendida(Mesa producto, String nombreCliente, Date fechaSolicitudGarantia) {
//
//		Map<String, Object> valoresGarantia = obtenerValoresGarantia(producto.getPrecio(), fechaSolicitudGarantia);
//		return new Reserva(
//				producto,
//				fechaSolicitudGarantia,
//				(Date) valoresGarantia.get(FECHA_FIN_GARANTIA),
//				(double) valoresGarantia.get(PRECIO_GARANTIA),
//				nombreCliente);
//	}

}
