package de.kaffeeundpopcorn.scooteq.repository;

import de.kaffeeundpopcorn.scooteq.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
}
