package com.ceiba.boardgamesnfood.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Mesa")
@NamedQuery(name = "Mesa.findByCodigo", query = "SELECT mesa FROM Mesa mesa WHERE mesa.codigo = :codigo")
@NamedQuery(name = "Mesa.findAll", query = "SELECT mesa FROM Mesa mesa")
public class MesaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String codigo;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
