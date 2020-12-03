package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.excepcion.MesaNoEncontradaException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesa;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.converter.MesaConverter;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.jpa.RepositorioMesaJPA;

@Repository
public class RepositorioMesaPersistente implements RepositorioMesa, RepositorioMesaJPA {

	private static final String CODIGO = "codigo";
	private static final String MESA_FIND_BY_CODIGO = "Mesa.findByCodigo";
	private static final String MESA_FIND_ALL = "Mesa.findAll";
	
	private EntityManager entityManager;

	public RepositorioMesaPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Mesa obtenerPorCodigo(String codigo) {
		MesaEntity mesaEntity = null;
		try {
			mesaEntity = obtenerMesaEntityPorCodigo(codigo);
		} catch (NoResultException nre) {
			throw new MesaNoEncontradaException(codigo);
		}
		
		return MesaConverter.convertirADominio(mesaEntity);
	}
	
	@Override
	public MesaEntity obtenerMesaEntityPorCodigo(String codigo) {
		
		Query query = entityManager.createNamedQuery(MESA_FIND_BY_CODIGO);
		query.setParameter(CODIGO, codigo);

		return (MesaEntity) query.getSingleResult();
	}

	@Override
	public void agregar(Mesa mesa) {
		entityManager.persist(MesaConverter.convertirAEntity(mesa));
	}

	@Override
	public List<Mesa> obtenerMesas() {
		
		return new ArrayList<>(obtenerMesasEntity().stream()
				.map(MesaConverter::convertirADominio)
				.collect(Collectors.toList()));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MesaEntity> obtenerMesasEntity() {
		
		Query query = entityManager.createNamedQuery(MESA_FIND_ALL);

		return query.getResultList();
	}

}
