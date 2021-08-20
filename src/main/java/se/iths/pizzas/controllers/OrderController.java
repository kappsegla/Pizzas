package se.iths.pizzas.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.iths.pizzas.messagingrabbitmq.RabbitMQConfiguration;

@RestController
public class OrderController {

    private final RabbitTemplate rabbitTemplate;

    public OrderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/orders")
    String orderPizza(@RequestBody Order newOrder) {
        var orderId = (int)(Math.random() * 10000);
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
                "foo.bar.baz", "One Margherita with no cheese. " + orderId);

        return "Thanks for your order: " + orderId;
    }
}
