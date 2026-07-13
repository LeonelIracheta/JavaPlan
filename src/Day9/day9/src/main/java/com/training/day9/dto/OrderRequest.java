package com.training.day9.dto;

import java.math.BigDecimal;

public class OrderRequest {

    private Long customerId;

    private BigDecimal total;

    public OrderRequest() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}