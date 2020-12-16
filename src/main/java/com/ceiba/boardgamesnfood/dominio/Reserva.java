package com.ceiba.boardgamesnfood.dominio;

import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.ceiba.boardgamesnfood.dominio.excepcion.DominioException;

public class Reserva {
	
	private static final String START_RESERVATION_DATE_ATTRIBUTE = "startReservationDate";
	private static final String NUMBER_PEOPLE_ATTRIBUTE = "numberPeople";
	private static final String TITULAR_ATTRIBUTE = "titular";
	private static final String GAME_ATTRIBUTE = "game";

	private Long id;
	private List<MesasPorReserva> mesas;
	private Date startReservationDate;
	private Date endReservationDate;
	private int numberPeople;
	private String titular;
	private JuegoType game;

	/**
	 * 
	 * @param id
	 */
	public Reserva(Long id) {
		super();
		this.id = id;
	}
	
	/**
	 * 
	 * @param startReservationDate
	 * @param numberPeople
	 * @param titular
	 * @param game
	 */
	public Reserva(Date startReservationDate, int numberPeople, String titular, JuegoType game) {
		super();
		setStartReservationDate(startReservationDate);
		setNumberPeople(numberPeople);
		setTitular(titular);
		setGame(game);
	}

	/**
	 * Full constructor
	 * @param id
	 * @param mesas
	 * @param startReservationDate
	 * @param endReservationDate
	 * @param numberPeople
	 * @param titular
	 * @param game
	 */
	public Reserva(Long id, List<MesasPorReserva> mesas, Date startReservationDate, Date endReservationDate,
			int numberPeople, String titular, JuegoType game) {
		super();
		this.id = id;
		this.mesas = mesas;
		this.startReservationDate = startReservationDate;
		this.endReservationDate = endReservationDate;
		this.numberPeople = numberPeople;
		this.titular = titular;
		this.game = game;
	}
	
	public Long getId() {
		return id;
	}

	public Date getStartReservationDate() {
		return startReservationDate;
	}

	public Date getEndReservationDate() {
		return endReservationDate;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public JuegoType getGame() {
		return game;
	}

	public List<MesasPorReserva> getMesas() {
		return mesas;
	}

	public String getTitular() {
		return titular;
	}
	
	private void setTitular(String titular) {
		if (StringUtils.isEmpty(titular)) {
			throw new DominioException(TITULAR_ATTRIBUTE, DominioException.ERRORES_DOMINIO.EMPTY);
		}
		this.titular = titular;
	}

	private void setGame(JuegoType game) {
		if (game == null) {
			throw new DominioException(GAME_ATTRIBUTE, DominioException.ERRORES_DOMINIO.EMPTY);
		}
		this.game = game;
	}

	private void setNumberPeople(int numberPeople) {
		if (numberPeople < 2 || numberPeople > 10) {
			throw new DominioException(NUMBER_PEOPLE_ATTRIBUTE, DominioException.ERRORES_DOMINIO.RANGE);
		}
		this.numberPeople = numberPeople;
	}
	
	private void setStartReservationDate(Date startReservationDate) {
		if (startReservationDate == null) {
			throw new DominioException(START_RESERVATION_DATE_ATTRIBUTE, DominioException.ERRORES_DOMINIO.EMPTY);
		}
		this.startReservationDate = startReservationDate;
	}

	
}
