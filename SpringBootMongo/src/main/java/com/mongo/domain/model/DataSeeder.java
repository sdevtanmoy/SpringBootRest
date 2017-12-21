/**
 * 
 */
package com.mongo.domain.model;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mongo.domain.repo.CarRepository;

/**
 * @author ibm
 *
 */
@Component
public class DataSeeder implements CommandLineRunner{

	private CarRepository carRepository;
	
	/**
	 * @param carRepository
	 */
	private DataSeeder(CarRepository carRepository) {
		this.carRepository = carRepository;
	}



	@Override
	public void run(String... strings) throws Exception {

		List<Car> cars = this.carRepository.findAll();
		System.out.println("**************************************************"+cars.size());
	}

}
