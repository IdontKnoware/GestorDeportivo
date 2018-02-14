package com.grupob.practicafinal.backend.services.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grupob.practicafinal.backend.models.Estado;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
//import com.grupob.practicafinal.backend.services.PartidoServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartidoServicesImplTest {

//	@Autowired
//	private PartidoServices partidoServices;
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Test
	public void test1() {
		
		List<Partido> partidos = partidoRepository.getPartidosPuntuables();
		
		for (Partido partido: partidos) {
			//System.out.println(partido);
			assertTrue(partido.getEstado() != Estado.PENDIENTE);
		}
		
	}
	
}
