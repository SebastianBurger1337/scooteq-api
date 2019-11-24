package de.kaffeeundpopcorn.scooteqapi.repository;

import de.kaffeeundpopcorn.scooteqapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
}
