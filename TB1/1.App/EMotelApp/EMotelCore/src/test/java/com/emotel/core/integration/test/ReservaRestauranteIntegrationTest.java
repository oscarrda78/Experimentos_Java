package com.emotel.core.integration.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.entities.ReservaRestaurante;
import com.emotel.core.service.IReservaRestauranteService;
import com.emotel.core.service.ReservaRestauranteService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ReservaRestauranteIntegrationTest {
	
	
	@Test
	public void a_Test_Reserva()
	{
		IReservaRestauranteService reservarestauranteService =
				Mockito.mock(ReservaRestauranteService.class);
		ReservaRestaurante reservaRestaurante = Mockito.mock(ReservaRestaurante.class);
		ReservaHotel reservaHotel = Mockito.mock(ReservaHotel.class);
		when(reservarestauranteService.mismoPaisReserva(new ReservaHotel(), 
				new ReservaRestaurante())).thenReturn(true);
		when(reservarestauranteService.agregar(new ReservaRestaurante())).thenReturn(true);
		
		if(reservarestauranteService.mismoPaisReserva(reservaHotel, reservaRestaurante))
		{
			reservarestauranteService.agregar(reservaRestaurante);
		}
	}
}
