package com.training.day11.controller;

import com.training.day11.dto.OrderRequest;
import com.training.day11.dto.OrderResponse;
import com.training.day11.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(
            @PathVariable Long id) {

        return orderService.getOrderById(id);
    }

    @PostMapping
    public OrderResponse createOrder(
            @RequestBody OrderRequest request) {

        return orderService.createOrder(request);
    }
}