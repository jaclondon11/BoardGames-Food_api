package com.ceiba.boardgamesnfood.dominio;

public class Mesa {
	private Long id;
	private String codigo;
	
	public Mesa(String codigo) {
		super();
		this.codigo = codigo;
	}

	public Mesa(Long id, String codigo) {
		this.id = id;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
