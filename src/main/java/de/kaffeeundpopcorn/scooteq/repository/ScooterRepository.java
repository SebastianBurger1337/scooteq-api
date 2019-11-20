package de.kaffeeundpopcorn.scooteq.repository;

import de.kaffeeundpopcorn.scooteq.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
