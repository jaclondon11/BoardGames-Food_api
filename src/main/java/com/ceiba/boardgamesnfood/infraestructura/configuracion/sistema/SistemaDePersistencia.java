package com.ceiba.boardgamesnfood.infraestructura.configuracion.sistema;

import javax.persistence.EntityManager;

import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;
import com.ceiba.boardgamesnfood.infraestructura.configuracion.conexion.ConexionJPA;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.RepositorioReservaPersistente;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.RepositorioProductoPersistente;

public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}

	public RepositorioProducto obtenerRepositorioProductos() {
		return new RepositorioProductoPersistente(entityManager);
	}
	
	public RepositorioReserva obtenerRepositorioGarantia() {
		return new RepositorioReservaPersistente(entityManager, this.obtenerRepositorioProductos());
	}

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
}
