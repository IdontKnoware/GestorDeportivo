package com.grupob.practicafinal.backend.services.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import com.grupob.practicafinal.backend.models.Clasificado;
import com.grupob.practicafinal.backend.services.ClasificacionServices;

@TestComponent
public class ClasificacionServicesImplTest {

	@Autowired
	private ClasificacionServices clasificacionServices;
	
	@Test
	public void test1() {
		List<Clasificado> clasificacion = clasificacionServices.getClasificacion();
		
		assertNotNull(clasificacion);
	
	}
	
}
