package com.ceiba.boardgamesnfood.infraestructura.configuracion.sistema;

import javax.persistence.EntityManager;

import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.infraestructura.configuracion.conexion.ConexionJPA;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.RepositorioMesaPersistente;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.RepositorioReservaPersistente;

public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}

	public RepositorioMesa obtenerRepositorioMesa() {
		return new RepositorioMesaPersistente(entityManager);
	}
	
	public RepositorioReserva obtenerRepositorioReserva() {
		return new RepositorioReservaPersistente(entityManager, this.obtenerRepositorioMesa());
	}

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
}
