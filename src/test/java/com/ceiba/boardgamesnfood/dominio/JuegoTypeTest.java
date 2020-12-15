package com.ceiba.boardgamesnfood.dominio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class JuegoTypeTest {

	@Test
	public void debeConvertirCorrectamenteDesdeString() {
		JuegoType juegoCatan = JuegoType.CATAN;
		JuegoType juegoCatanExpected = JuegoType.CATAN;
		assertThat(JuegoType.fromString(juegoCatan.getGameName()).equals(juegoCatanExpected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void noDebeConvertirCorrectamenteDesdeString() {
		JuegoType.fromString(" NADA ");
	}
}
