package com.training.day9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.day9.dto.OrderRequest;
import com.training.day9.dto.OrderResponse;
import com.training.day9.entity.Customer;
import com.training.day9.entity.Order;
import com.training.day9.repository.CustomerRepository;
import com.training.day9.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(
            OrderRepository orderRepository,
            CustomerRepository customerRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<OrderResponse> getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        return toResponse(order);
    }

    public OrderResponse createOrder(OrderRequest request) {

        Customer customer = customerRepository.findById(
                        request.getCustomerId())
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setTotal(request.getTotal());
        order.setCustomer(customer);

        Order savedOrder =
                orderRepository.save(order);

        return toResponse(savedOrder);
    }

    private OrderResponse toResponse(Order order) {

        OrderResponse response =
                new OrderResponse();

        response.setId(order.getId());
        response.setTotal(order.getTotal());
        response.setCustomerName(
                order.getCustomer().getName());

        return response;
    }
}