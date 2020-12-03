package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesasPorReserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.converter.MesaConverter;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;

@Repository
public class RepositorioMesasPorReservaPersistente implements RepositorioMesasPorReserva {

	private static final String FECHA_INICIO_RESERVA = "fechaInicioReserva";
	private static final String MESAS_CON_RESERVA_FIND_BY_DATE = "MesasPorReserva.findMesasConReservas";
	
	private EntityManager entityManager;

	public RepositorioMesasPorReservaPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Mesa> obtenerMesasConReservaByFecha(Date fechaReserva) {
		
		List<MesaEntity> mesas = obtenerMesasConReservaByFechaQuery(fechaReserva);
		
		return mesas == null ? null
				: mesas.stream().map(MesaConverter::convertirADominio)
				.collect(Collectors.toList());
				
	}

	@SuppressWarnings("unchecked")
	private List<MesaEntity> obtenerMesasConReservaByFechaQuery(Date fechaReserva) {
		
		Query query = entityManager.createNamedQuery(MESAS_CON_RESERVA_FIND_BY_DATE);
		query.setParameter(FECHA_INICIO_RESERVA, fechaReserva);
		
		return query.getResultList();
		
	}

}
