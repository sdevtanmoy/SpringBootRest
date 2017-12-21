/**
 * 
 */
package com.mongo.domain.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.domain.model.Car;

/**
 * @author ibm
 *
 */
public interface CarRepository extends MongoRepository<Car, String>{

}
