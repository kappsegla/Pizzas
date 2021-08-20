package se.iths.pizzas;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.pizzas.entities.Pizza;
import se.iths.pizzas.messagingrabbitmq.Receiver;
import se.iths.pizzas.repositories.PizzaRepository;

@SpringBootApplication
public class PizzasApplication {

      public static void main(String[] args) {
        SpringApplication.run(PizzasApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PizzaRepository pizzaRepository){
        return args -> {
            if( pizzaRepository.count() == 0) {
                pizzaRepository.save(new Pizza(0L,"Hawaii",80,"Ost,Tomatsås,Skinka,Ananas"));
            }
        };
    }
}
