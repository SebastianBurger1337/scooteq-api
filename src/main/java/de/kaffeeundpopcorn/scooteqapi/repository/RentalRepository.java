package de.kaffeeundpopcorn.scooteqapi.repository;

import de.kaffeeundpopcorn.scooteqapi.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
