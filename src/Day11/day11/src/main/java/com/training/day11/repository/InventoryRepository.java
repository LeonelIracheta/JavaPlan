package com.training.day11.repository;

import com.training.day11.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {
}