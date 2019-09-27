package de.kaffeeundpopcorn.scooteq.controller;

import de.kaffeeundpopcorn.scooteq.model.Customer;
import de.kaffeeundpopcorn.scooteq.repository.CustomerRepository;
import de.kaffeeundpopcorn.scooteq.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author Sebastian Burger
 * File Controller for the WKZ REST api.
 * This class contains the get and post mappings.
 */
@RestController
public class ApiController
{

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * GET Mapping for /health
     *
     * @return A ResponseEntity with Status OK
     * FIXME: Doesn't actually do a health check :)
     */
    @GetMapping("/v1/health")
    public @ResponseBody
    RedirectView health()
    {
        return new RedirectView("https://http.cat/200.jpg");
    }

    @GetMapping("/v1/customer/{customerId}")
    public @ResponseBody
    ResponseEntity<Customer> getCustomer(@PathVariable(value = "customerId") Long customerID) throws ChangeSetPersister.NotFoundException
    {
        System.out.println("Searching for customer " + customerID);
        Customer customer = customerRepository.findById(customerID).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/v1/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

}
