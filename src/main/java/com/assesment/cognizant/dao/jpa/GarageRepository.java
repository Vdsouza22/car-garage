package com.assesment.cognizant.dao.jpa;

import com.assesment.cognizant.domain.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository can be used to delegate CRUD operations against MongoDB
 * @author Vinita
 */
@Repository
public interface GarageRepository extends MongoRepository<Cars, String> {
	Cars findById(int id);
}
