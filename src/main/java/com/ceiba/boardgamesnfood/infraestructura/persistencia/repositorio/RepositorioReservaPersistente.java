package com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.boardgamesnfood.dominio.Mesa;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioProducto;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.builder.MesaConverter;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.ReservaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad.MesaEntity;
import com.ceiba.boardgamesnfood.infraestructura.persistencia.repositorio.jpa.RepositorioProductoJPA;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {

	private static final String ID = "id";
	private static final String RESERVA_FIND_BY_ID = "Reserva.findById";

	private EntityManager entityManager;

	private RepositorioProductoJPA repositorioProductoJPA;

	public RepositorioReservaPersistente(EntityManager entityManager, RepositorioProducto repositorioProducto) {
		this.entityManager = entityManager;
		this.repositorioProductoJPA = (RepositorioProductoJPA) repositorioProducto;
	}
	
	@Override
	public Reserva obtener(String id) {
		
		ReservaEntity reserva = obtenerReservaEntityPorId(id);

		return reserva == null ? null
				: new Reserva(
						MesaConverter.convertirADominio(reserva.getProducto()),
						reserva.g,
						reserva.getFechaFinGarantia(),
						reserva.getPrecio(),
						reserva.getNombreCliente());
	}

	@Override
	public void agregar(Reserva garantia) {
		ReservaEntity garantiaEntity = buildGarantiaExtendidaEntity(garantia);
		entityManager.persist(garantiaEntity);
		
	}
	
	@Override
	public Mesa obtenerProductoConGarantiaPorCodigo(String codigo) {
		
		ReservaEntity garantiaEntity = obtenerReservaEntityPorId(codigo);
      		return MesaConverter.convertirADominio(garantiaEntity != null ? garantiaEntity.getProducto() : null);
	}
	
	@SuppressWarnings("rawtypes")
	private ReservaEntity obtenerReservaEntityPorId(String id) {

		Query query = entityManager.createNamedQuery(RESERVA_FIND_BY_ID);
		query.setParameter(ID, id);

		List resultList = query.getResultList();

		return !resultList.isEmpty() ? (ReservaEntity) resultList.get(0) : null;
	}

	private ReservaEntity buildGarantiaExtendidaEntity(Reserva garantia) {

		MesaEntity productoEntity = repositorioProductoJPA.obtenerProductoEntityPorCodigo(garantia.getProducto().getCodigo());

		ReservaEntity garantiaEntity = new ReservaEntity();
		garantiaEntity.setProducto(productoEntity);
		garantiaEntity.setFechaSolicitudGarantia(garantia.getFechaSolicitudGarantia());
		garantiaEntity.setFechaFinGarantia(garantia.getFechaFinGarantia());
		garantiaEntity.setNombreCliente(garantia.getNombreCliente());
		garantiaEntity.setPrecio(garantia.getPrecioGarantia());
		
		return garantiaEntity;
	}
}
