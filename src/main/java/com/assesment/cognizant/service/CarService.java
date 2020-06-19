package com.assesment.cognizant.service;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assesment.cognizant.dao.jpa.GarageRepository;
import com.assesment.cognizant.domain.Cars;


/**
 * Service class to fetch the necessary information 
 * from MongoDB for each defined API request
 * @author Vinita
 *
 */
@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private GarageRepository garageRepository;

    public CarService() {
    }

    /**
     * Method to fetch the car by id
     * @param id
     * @return cars
     */
    public Cars getCar(int id) {
    	log.info("Request to fetch all the cars");
        return garageRepository.findById(id);
    }
    
    /**
     * Method to fetch all the cars
     * @param id
     * @return cars
     */
    public List<Cars> getAllCars() {
    	log.info("Request to fetch a specific car");
        List<Cars> pageOfCars = garageRepository.findAll(); 
        return pageOfCars;
    }
}
