package com.assesment.cognizant.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.assesment.cognizant.dao.jpa.GarageRepository;
import com.assesment.cognizant.domain.Cars;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private GarageRepository garageRepository;

    public CarService() {
    }


    public Cars getCar(int id) {
        return garageRepository.findById(id);
    }


    public List<Cars> getAllCars() {
        List<Cars> pageOfCars = garageRepository.findAll(); 
        return pageOfCars;
    }
}
