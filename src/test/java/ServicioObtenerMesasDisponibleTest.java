

import static org.mockito.Mockito.mock;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

import org.junit.Test;

import com.ceiba.boardgamesnfood.dominio.JuegoType;
import com.ceiba.boardgamesnfood.dominio.Reserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioMesasPorReserva;
import com.ceiba.boardgamesnfood.dominio.repositorio.RepositorioReserva;
import com.ceiba.boardgamesnfood.dominio.servicio.reserva.ServicioGenerarReserva;
import com.ceiba.boardgamesnfood.utils.DateUtils;
public class ServicioObtenerMesasDisponibleTest {

//	@Test
//	public void debeReservarSatisfactoriamenteCuandoFechaEsEnSemanaALas5pm() {
//		
//		//arrange
//		RepositorioMesasPorReserva repositorioMesasPorReserva = mock(RepositorioMesasPorReserva.class);
//		RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
//		ServicioGenerarReserva servicio = new ServicioGenerarReserva(repositorioMesasPorReserva, repositorioReserva);
////		Date fechaInicioReserva = DateUtils
////				.convertirLocalDateTimeToDate(LocalDateTime.of(2020, Month.DECEMBER, 2, 17, 0, 0));
//		
//		
//		//act
//		servicio.obtenerMesasConReservaByFecha(prospectoReserva);
//		
//		//assert
//	}
//	
//	@Test
//	public void debeIndicarNoDisnobilidadDeMesasSiFechaReservaNoCuentaConMesas() {
//		
//		//arrange
//		RepositorioMesasPorReserva repositorioMesasPorReserva = mock(RepositorioMesasPorReserva.class);
//		RepositorioReserva repositorioReserva = mock(RepositorioReserva.class);
//		ServicioGenerarReserva servicio = new ServicioGenerarReserva(repositorioMesasPorReserva, repositorioReserva);
//		Date fechaInicioReserva;
//		int cantidadPersonas;
//		String titular;
//		JuegoType juego;
//		Reserva prospectoReserva = new Reserva(fechaInicioReserva, cantidadPersonas, titular, juego);
//		
//		//act
//		servicio.generarReserva(prospectoReserva);
//		
//		//assert
//	}

}
