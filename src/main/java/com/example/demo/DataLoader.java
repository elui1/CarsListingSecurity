package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... strings) throws Exception {

        Category category = new Category();
        category.setName("Win");

        Car car = new Car();
        car.setManufacturer("lorem");
        car.setModel("ipsum");
        car.setYear("1987");
        car.setMSRP(1.5);

        Set<Car> cars = new HashSet<>();
        cars.add(car);
        category.setCars(cars);
        categoryRepository.save(category);

        car.setCategory(category);
        carRepository.save(car);

        //more initializations
        category = new Category();
        category.setName("Boss");

        car = new Car();
        car.setManufacturer("kuma");
        car.setModel("dude");
        car.setYear("2005");
        car.setMSRP(3.8);

        cars = new HashSet<>();
        cars.add(car);
        category.setCars(cars);
        categoryRepository.save(category);

        car.setCategory(category);
        carRepository.save(car);
    }

}
