package com.ceiba.boardgamesnfood.infraestructura.controllador;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ceiba.boardgamesnfood.aplicacion.comando.ComandoReserva;
import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.dominio.excepcion.EntityNoEncontradaException;
import com.ceiba.boardgamesnfood.testdatabuilder.ReservaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorReservaTest {

	@Autowired
	private MockMvc mvc;
	
    @Autowired
    private ObjectMapper objectMapper;

	@Test
	public void debeRetornarReservaSiExiste() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/reserva/{id}", 1L)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.titular").value("TITULAR_1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.juego").value(JuegoType.EXPLODING_KITTENS.name()));
	}
	
	@Test
	public void debeRetornarNotFoundSiReservaNoExiste() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/reserva/{id}", 0L)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNotFound())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nombreExcepcion").value(EntityNoEncontradaException.class.getSimpleName()));	
	}
	
	@Test
	public void debeCrearReserva() throws Exception {
		Date fecha = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-12-04-15:00:00");
		
		ComandoReserva comandoReserva = ReservaTestDataBuilder.build()
				.conTitular("TITULAR")
				.conFecha(fecha)
				.conJuego(JuegoType.CATAN)
				.conCantidadPersonas(4)
				.getComando();
		
		mvc.perform(MockMvcRequestBuilders
				.post("/reserva")
				.content(objectMapper.writeValueAsString(comandoReserva))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
		
	}
	
}
