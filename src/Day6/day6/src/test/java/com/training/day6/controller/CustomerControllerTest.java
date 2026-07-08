package com.training.day6.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.day6.dto.CustomerRequest;
import com.training.day6.dto.CustomerResponse;
import com.training.day6.service.CustomerService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    void shouldReturnAllCustomers() throws Exception {

        CustomerResponse customer = new CustomerResponse();
        customer.setId(1L);
        customer.setName("Leonel");
        customer.setEmail("leo@test.com");

        when(customerService.getAllCustomers())
                .thenReturn(List.of(customer));

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Leonel"))
                .andExpect(jsonPath("$[0].email").value("leo@test.com"));
    }

    @Test
    void shouldReturnCustomerById() throws Exception {

        CustomerResponse customer = new CustomerResponse();
        customer.setId(1L);
        customer.setName("Leonel");
        customer.setEmail("leo@test.com");

        when(customerService.getCustomerById(1L))
                .thenReturn(customer);

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Leonel"))
                .andExpect(jsonPath("$.email").value("leo@test.com"));
    }

    @Test
    void shouldCreateCustomer() throws Exception {

        CustomerRequest request = new CustomerRequest();
        request.setName("John");
        request.setEmail("john@test.com");

        CustomerResponse response = new CustomerResponse();
        response.setId(2L);
        response.setName("John");
        response.setEmail("john@test.com");

        when(customerService.createCustomer(any(CustomerRequest.class)))
                .thenReturn(response);

        mockMvc.perform(
                        post("/customers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.email").value("john@test.com"));
    }
}