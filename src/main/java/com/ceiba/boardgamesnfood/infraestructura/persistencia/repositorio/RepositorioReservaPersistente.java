package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.excepcion.EntityNoEncontradaException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
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
		
		return ReservaConverter.convertirADominio(reservaEntity);
		
	}

	@Override
	public Reserva agregar(Reserva reserva) {
		entityManager.flush();
		ReservaEntity reservaEntityPersisted = entityManager.merge(ReservaConverter.convertirAEntity(reserva));
		entityManager.refresh(reservaEntityPersisted);
		return ReservaConverter.convertirADominio(reservaEntityPersisted);
	}
	
	private ReservaEntity obtenerReservaEntityPorId(Long id) {

		Query query = entityManager.createNamedQuery(RESERVA_FIND_BY_ID);
		query.setParameter(ID, id);

		return (ReservaEntity) query.getSingleResult();
	}

}
