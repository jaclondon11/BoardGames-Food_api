package com.ceiba.boardgamesnfood.dominio.servicio.vendedor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.excepcion.GarantiaCodigoProductoPorVocalesException;
import com.ceiba.boardgamesnfood.dominio.excepcion.GarantiaExtendidaException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;
import com.ceiba.boardgamesnfood.utils.CharUtils;
import com.ceiba.boardgamesnfood.utils.DateUtils;

public class ServicioVendedor {

	private static final String PRECIO_GARANTIA = "precioGarantia";

	private static final String FECHA_FIN_GARANTIA = "fechaFinGarantia";

	public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garant�a extendida";

	private RepositorioProducto repositorioProducto;
	private RepositorioReserva repositorioGarantia;

	public ServicioVendedor(RepositorioProducto repositorioProducto,
			RepositorioReserva repositorioGarantia) {
		this.repositorioProducto = repositorioProducto;
		this.repositorioGarantia = repositorioGarantia;
	}

	public void generarGarantia(String codigo, String nombreCliente) {
		Mesa producto = this.repositorioProducto.obtenerPorCodigo(codigo);
		if (tieneGarantia(codigo)) {
			throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);
		}
		if (tiene3Vocales(codigo)) {
			throw new GarantiaCodigoProductoPorVocalesException();
		}
		Reserva garantia = crearGarantiaExtendida(producto, nombreCliente, new Date());
		repositorioGarantia.agregar(garantia);
	}

	/**
	 * Este metodo filtra las vocales del codigo, luego cuenta cuantas vocales sin
	 * repetir tiene el codigo y al final revisa s� las vocales restantes que no
	 * estaban en el codigo son 2, de esta forma se sabe que hab�an 3 vocales sin
	 * repetir
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean tiene3Vocales(String codigo) {
		Set<Character> vocales = new HashSet<>(CharUtils.getVocalesMayus());
		
		codigo.toUpperCase().codePoints()
		.mapToObj(i -> (char) i)
		.distinct()
		.filter(c -> CharUtils.esVocal(c))
		.forEach(c -> vocales.remove(c));
		
		return vocales.stream().count() == 2;
	}

	public boolean tieneGarantia(String codigo) {
		Mesa producto = repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo);
		return producto != null;
	}
	
	public Reserva crearGarantiaExtendida(Mesa producto, String nombreCliente, Date fechaSolicitudGarantia) {

		Map<String, Object> valoresGarantia = obtenerValoresGarantia(producto.getPrecio(), fechaSolicitudGarantia);
		return new Reserva(
				producto,
				fechaSolicitudGarantia,
				(Date) valoresGarantia.get(FECHA_FIN_GARANTIA),
				(double) valoresGarantia.get(PRECIO_GARANTIA),
				nombreCliente);
	}

	private Map<String, Object> obtenerValoresGarantia(double precio, Date fechaSolicitudGarantia) {
		Map<String, Object> valoresGarantia = new HashMap<>();
		LocalDateTime localDateTime = DateUtils.convertirDateToLocalDateTime(fechaSolicitudGarantia);
		if (precio > 500_000d) {
			Date fecha = DateUtils.agregarDiasSinLunes(localDateTime, 200);
			fecha = DateUtils.moverDiaSiEsDomingoDiaActual(DateUtils.convertirDateToLocalDateTime(fecha));
			valoresGarantia.put(FECHA_FIN_GARANTIA, fecha);
			valoresGarantia.put(PRECIO_GARANTIA, precio*0.2);
		}else {
			valoresGarantia.put(FECHA_FIN_GARANTIA, DateUtils.convertirLocalDateTimeToDate(localDateTime.plusDays(100)));
			valoresGarantia.put(PRECIO_GARANTIA, precio*0.1);
		}
		return valoresGarantia;
	}
}
