package com.assesment.cognizant.api.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * This class is the entry point for th apis
 * @author Vinita
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/v1/cars")
@Api(tags = { "cars" })
public class CarController extends AbstractRestHandler {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CarService carService;

	public CarController() {
	}

	/**
	 * This method is for retrieving all the cars
	 * 
	 * @param request
	 * @param response
	 * @return ResponseEntity<List<Cars>>
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Gets a list of all cars.", notes = "The list gives all the required details of a car along with its Warehouse and location")
	public @ResponseBody ResponseEntity<List<Cars>> getAllCars(HttpServletRequest request,
			HttpServletResponse response) {
		List<Cars> carList = this.carService.getAllCars();
		if (carList.isEmpty()) {
			log.error("No cars available");
			throw new ResourceNotFoundException("Not records for cars");
		}
		return new ResponseEntity<List<Cars>>(carList, HttpStatus.OK);
	}

	/**
	 * This method is for retrieving a specific car
	 * 
	 * @param request
	 * @param response
	 * @return ResponseEntityt<Cars>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get a single car.", notes = "You have to provide a valid car ID.")
	public @ResponseBody ResponseEntity<Cars> getCarById(
			@ApiParam(value = "The ID of the car.", required = true) @PathVariable("id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		Cars car = this.carService.getCar(id);
		if (car == null) {
			log.error("No cars available for the id :" + id);
			throw new ResourceNotFoundException("Requested car not present");
		}
		return new ResponseEntity<Cars>(car, HttpStatus.OK);
	}

}
