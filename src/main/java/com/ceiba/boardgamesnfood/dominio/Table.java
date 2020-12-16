package com.ceiba.boardgamesnfood.dominio;

import org.springframework.util.StringUtils;

import com.ceiba.boardgamesnfood.dominio.excepcion.DominioException;

public class Table {
	private static final String CODE_ATTRIBUTE = "code";
	private Long id;
	private String code;
	
	/*
	 * Tener validaciones de campos
	 */
	public Table(String code) {
		super();
		this.code = code;
	}

	public Table(Long id, String code) {
		this.id = id;
		setCode(code);
	}
	
	private void setCode(String code) {
		if (StringUtils.isEmpty(code)) {
			throw new DominioException(CODE_ATTRIBUTE, DominioException.ERRORES_DOMINIO.EMPTY);
		}
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Table other = (Table) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
