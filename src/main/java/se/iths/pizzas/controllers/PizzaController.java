package se.iths.pizzas.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.iths.pizzas.entities.Pizza;
import se.iths.pizzas.repositories.PizzaRepository;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String id;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/pizzas")
    public List<Pizza> pizzas() {

        //throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        return pizzaRepository.findAll();
    }

    @PostMapping("/pizzas")
    Pizza newPizza(@RequestBody Pizza newPizza) {
        return pizzaRepository.save(newPizza);
    }

    @GetMapping("/pizzas/test")
    public String test() {

        List<String> strings = List.of();

        return id;
    }
}
