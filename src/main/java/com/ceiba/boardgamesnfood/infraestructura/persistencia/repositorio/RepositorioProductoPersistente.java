package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.excepcion.ProductoNoEncontradoException;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.builder.MesaConverter;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.jpa.RepositorioProductoJPA;

@Repository
public class RepositorioProductoPersistente implements RepositorioProducto, RepositorioProductoJPA {

	private static final String CODIGO = "codigo";
	private static final String PRODUCTO_FIND_BY_CODIGO = "Producto.findByCodigo";
	
	private EntityManager entityManager;

	public RepositorioProductoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public Mesa obtenerPorCodigo(String codigo) {
		MesaEntity productoEntity = null;
		try {
			productoEntity = obtenerProductoEntityPorCodigo(codigo);
		} catch (NoResultException nre) {
			throw new ProductoNoEncontradoException(codigo);
		}
		
		return MesaConverter.convertirADominio(productoEntity);
	}
	
	@Override
	public MesaEntity obtenerProductoEntityPorCodigo(String codigo) {
		
		Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CODIGO);
		query.setParameter(CODIGO, codigo);

		return (MesaEntity) query.getSingleResult();
	}

	@Override
	public void agregar(Mesa producto) {
		entityManager.persist(MesaConverter.convertirAEntity(producto));
	}	

	

}
