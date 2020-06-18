package com.assesment.cognizant.dao.jpa;

import com.assesment.cognizant.domain.Cars;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



/**
 * Repository can be used to delegate CRUD operations against the data source
 */
@Repository
public interface GarageRepository extends MongoRepository<Cars, String> {
	
	Cars findById(int id);
    Page findAll(Pageable pageable);
}
