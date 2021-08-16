package se.iths.pizzas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.pizzas.entities.Pizza;

import java.util.List;

@RestController
public class PizzaController {

    @GetMapping("/pizzas")
    public List<Pizza> pizzas() {
        return List.of(new Pizza(1L,"Margerita",50,"ost,tomatsås"));
    }
}
