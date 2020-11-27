package com.ceiba.boardgamesnfood.aplicacion.comando;

import javax.validation.constraints.Min;

public class ComandoProducto {
	private Long id;
	private String codigo;
	private String nombre;
	@Min(value = 0)
	private double precio;

	public ComandoProducto() {
		super();
	}

	public ComandoProducto(String codigo, String nombre, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public Long getId() {
		return id;
	}

}
