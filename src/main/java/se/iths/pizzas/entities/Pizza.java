package se.iths.pizzas.entities;

import javax.persistence.*;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String ingridients;

    public Pizza() {
    }

    public Pizza(Long id, String name, int price, String ingridients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingridients = ingridients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }
}
