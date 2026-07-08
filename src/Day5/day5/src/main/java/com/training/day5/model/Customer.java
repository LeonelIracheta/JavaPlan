package com.training.day5.model;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private String internalCode;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String internalCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.internalCode = internalCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }
}