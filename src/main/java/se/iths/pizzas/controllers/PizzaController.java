package se.iths.pizzas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.pizzas.entities.Pizza;
import se.iths.pizzas.repositories.PizzaRepository;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/pizzas")
    public List<Pizza> pizzas() {
        return pizzaRepository.findAll();
    }
}
