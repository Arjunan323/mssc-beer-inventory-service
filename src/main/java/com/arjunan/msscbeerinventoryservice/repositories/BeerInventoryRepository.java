package com.arjunan.msscbeerinventoryservice.repositories;

import com.arjunan.msscbeerinventoryservice.domain.BeerInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {
}
