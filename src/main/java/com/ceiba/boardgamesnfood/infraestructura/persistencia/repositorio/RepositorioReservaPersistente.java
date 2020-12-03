package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.excepcion.EntityNoEncontradaException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.converter.MesasPorReservaConverter;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.converter.ReservaConverter;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.ReservaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.jpa.RepositorioMesaJPA;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {

	private static final String ID = "id";
	private static final String RESERVA_FIND_BY_ID = "Reserva.findById";

	private EntityManager entityManager;

	@SuppressWarnings("unused")
	private RepositorioMesaJPA repositorioMesaJPA;

	public RepositorioReservaPersistente(EntityManager entityManager, RepositorioMesa repositorioMesa) {
		this.entityManager = entityManager;
		this.repositorioMesaJPA = (RepositorioMesaJPA) repositorioMesa;
	}
	
	@Override
	public Reserva obtener(Long id) {
		ReservaEntity reservaEntity = null;
		try {
			reservaEntity = obtenerReservaEntityPorId(id);
		} catch (NoResultException nre) {
			throw new EntityNoEncontradaException(Long.toString(id));
		}
		
		return new Reserva(
						reservaEntity.getId(),
						MesasPorReservaConverter.convertirADominioList(reservaEntity.getMesasReserva()),
						reservaEntity.getFechaInicioReserva(),
						reservaEntity.getFechaFinReserva(),
						reservaEntity.getCantidadPersonas(),
						reservaEntity.getTitular(),
						reservaEntity.getJuego());
	}

	@Override
	public void agregar(Reserva reserva) {
		ReservaEntity reservaEntity = ReservaConverter.convertirAEntity(reserva);
		entityManager.persist(reservaEntity);
		
	}
	
	@SuppressWarnings("rawtypes")
	private ReservaEntity obtenerReservaEntityPorId(Long id) {

		Query query = entityManager.createNamedQuery(RESERVA_FIND_BY_ID);
		query.setParameter(ID, id);
		List resultList = query.getResultList();

		return !resultList.isEmpty() ? (ReservaEntity) resultList.get(0) : null;
	}

}
