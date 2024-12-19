package org.example.orderservice;

import org.example.shared.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @GetMapping
    public String showOrderForm() {
        return "order-form";
    }

    @PostMapping
    public String placeOrder(@RequestParam String product, @RequestParam int quantity) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setProduct(product);
        order.setQuantity(quantity);
        orderProducer.sendOrder(order);
        return "redirect:/orders?success";
    }
}


