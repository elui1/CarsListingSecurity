package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/processCategory")
    public String processCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/";
    }

    @GetMapping("/addCar")
    public String addCar(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/processCar")
    public String processCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("categories", categoryRepository.findAll());
        return "carform";
    }

    @RequestMapping("/delete/{id}")
    public String delCar(@PathVariable("id") long id) {
        carRepository.deleteById(id);
        return "redirect:/";
    }
}
