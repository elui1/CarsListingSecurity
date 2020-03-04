package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... strings) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("jim@jim.com", "password", "Jim", "Jimmerson",
                true, "jim");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        user = new User("admin@admin.com", "password", "Admin", "User",
                true, "admin");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        Category category = new Category();
        category.setName("Win");

        Car car = new Car();
        car.setManufacturer("lorem");
        car.setModel("ipsum");
        car.setYear("1987");
        car.setMSRP(1.5);
        car.setPic("img/blue.jpg");


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
        car.setPic("img/sonata.jpg");

        cars = new HashSet<>();
        cars.add(car);
        category.setCars(cars);
        categoryRepository.save(category);

        car.setCategory(category);
        carRepository.save(car);
    }

}
