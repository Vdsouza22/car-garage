package com.assesment.cognizant.api.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.cognizant.domain.Cars;
import com.assesment.cognizant.exception.ResourceNotFoundException;
import com.assesment.cognizant.service.CarService;

/*
 * Class to Set up REST APIs
 */

@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarController extends AbstractRestHandler {
	@Autowired
	private CarService carService;

	public CarController() {
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseEntity<List<Cars>> getAllCars(HttpServletRequest request, HttpServletResponse response) {
		 List<Cars> carList = this.carService.getAllCars(); 	
		 if(carList.isEmpty())
			 throw new ResourceNotFoundException("Not records for cars");
		 return  new ResponseEntity<List<Cars>>(carList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseEntity<Cars> getCarById(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) {
		Cars car = this.carService.getCar(id);
		if(car==null)
			throw new ResourceNotFoundException("Requested car not present");
		return new ResponseEntity<Cars>(car,HttpStatus.OK);	
	}

}
