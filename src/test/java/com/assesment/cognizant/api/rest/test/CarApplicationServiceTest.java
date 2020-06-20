package com.assesment.cognizant.api.rest.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.assesment.cognizant.dao.jpa.GarageRepository;
import com.assesment.cognizant.domain.Cars;
import com.assesment.cognizant.exception.ResourceNotFoundException;
import com.assesment.cognizant.service.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarApplicationServiceTest {

	@Autowired
	private CarService carService;

	@MockBean
	private GarageRepository repository;
	
	@Test
	public void getCarsTest() throws ParseException {
		when(repository.findAll()).thenReturn(Stream
				.of(new Cars(1, "Volkswagen", "Jetta III", 1995, 12947.52, true,
						new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-18"), "Warehouse A", "Bangalore"))
				.collect(Collectors.toList()));
		assertEquals(1, carService.getAllCars().size());
	}
	
	@Test
	public void getCarsByIdTest() throws ParseException {
		int id =2;
		when(repository.findById(id)).thenReturn(new Cars(2,"Volkswagen", "Jetta III", 1995, 12947.52, true,
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-18"), "Warehouse A", "Bangalore"));
		assertNotNull(carService.getCar(id));
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void getCarsWithNoIdTest() {
		int id =2;
		when(repository.findById(id)).thenThrow(new ResourceNotFoundException());
		carService.getCar(id);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void getCarsWithNoValuesTest() {
		when(repository.findAll()).thenThrow(new ResourceNotFoundException());
		carService.getAllCars();
	}

}
