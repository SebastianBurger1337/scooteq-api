package de.kaffeeundpopcorn.scooteq.repository;

import de.kaffeeundpopcorn.scooteq.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
