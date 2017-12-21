/**
 * 
 */
package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.domain.model.Car;
import com.mongo.domain.repo.CarRepository;

/**
 * @author ibm
 *
 */

@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired(required = true)
	private CarRepository carRepository;
	
	@GetMapping(
			value = "/cars",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<List<Car>> getAllCars(){
		List<Car> carList = null;
		
		try{
			carList = this.carRepository.findAll();
			
			if(null != carList && carList.size() > 0){
				return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<List<Car>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
