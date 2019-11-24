package de.kaffeeundpopcorn.scooteqapi.repository;

import de.kaffeeundpopcorn.scooteqapi.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
