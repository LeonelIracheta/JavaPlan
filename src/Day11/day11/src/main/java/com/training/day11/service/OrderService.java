package com.training.day11.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.day11.dto.OrderRequest;
import com.training.day11.dto.OrderResponse;
import com.training.day11.entity.Customer;
import com.training.day11.entity.Inventory;
import com.training.day11.entity.Order;
import com.training.day11.repository.CustomerRepository;
import com.training.day11.repository.InventoryRepository;
import com.training.day11.repository.OrderRepository;

@Service
public class OrderService {

    private final InventoryRepository inventoryRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(
            OrderRepository orderRepository,
            CustomerRepository customerRepository,
            InventoryRepository inventoryRepository) {

                this.orderRepository = orderRepository;
                this.customerRepository = customerRepository;
                this.inventoryRepository = inventoryRepository;
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

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {

        Customer customer = customerRepository.findById(
                        request.getCustomerId())
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setTotal(request.getTotal());
        order.setCustomer(customer);

        Order savedOrder = orderRepository.save(order);

        if (true){
                throw new RuntimeException("Forced error");
        }

        Inventory inventory =
                inventoryRepository.findById(1L)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Inventory not found"));

        inventory.setQuantity(
                inventory.getQuantity() - 1);
        
        inventoryRepository.save(inventory);

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