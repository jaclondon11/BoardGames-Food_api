package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.converter.MesasPorReservaConverter;
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
	public Reserva obtener(String id) {
		
		ReservaEntity reserva = obtenerReservaEntityPorId(id);
		return reserva == null ? null
				: new Reserva(
						reserva.getId(),
						MesasPorReservaConverter.convertirADominioList(reserva.getMesasReserva()),
						reserva.getFechaInicioReserva(),
						reserva.getFechaFinReserva(),
						reserva.getCantidadPersonas(),
						reserva.getTitular(),
						reserva.getJuego());
	}

	@Override
	public void agregar(Reserva reserva) {
		Reserva reservaEntity = buildReservaEntity(reserva);
		entityManager.persist(reservaEntity);
		
	}
	
	@SuppressWarnings("rawtypes")
	private ReservaEntity obtenerReservaEntityPorId(String id) {

		Query query = entityManager.createNamedQuery(RESERVA_FIND_BY_ID);
		query.setParameter(ID, id);

		List resultList = query.getResultList();

		return !resultList.isEmpty() ? (ReservaEntity) resultList.get(0) : null;
	}

	private Reserva buildReservaEntity(Reserva reserva) {

		
		Reserva reservaEntity = new Reserva();
//		reservaEntity.setMesas(MesasPorReservaConverter.convertirAEntityList(reserva.getMesas()));
//		reservaEntity.setFechaInicioReserva(reserva.getFechaInicioReserva());
//		reservaEntity.setFechaFinReserva(reserva.getFechaFinReserva());
//		reservaEntity.setCantidadPersonas(reserva.getCantidadPersonas());
//		reservaEntity.setTitular(reserva.getTitular());
//		reservaEntity.setJuego(reserva.getJuego());
		
		return reservaEntity;
	}
}
