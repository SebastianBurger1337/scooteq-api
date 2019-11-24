package de.kaffeeundpopcorn.scooteqapi.controller;

import de.kaffeeundpopcorn.scooteqapi.model.Customer;
import de.kaffeeundpopcorn.scooteqapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static de.kaffeeundpopcorn.scooteqapi.ScooteqAPI.LOGGER;

/**
 * @author Sebastian Burger
 * File Controller for the WKZ REST api.
 * This class contains the get and post mappings.
 */
@RestController
public class ApiController
{

    private final CustomerRepository customerRepository;

    public ApiController(CustomerRepository customerRepository, ServletContext servletContext)
    {
        this.customerRepository = customerRepository;
    }

    /**
     * GET Mapping for /health
     *
     * @return A ResponseEntity with Status OK
     * FIXME: Doesn't actually do a health check :)
     */
    @GetMapping("/v1/health")
    public @ResponseBody
    ResponseEntity health(HttpServletResponse response) throws IOException
    {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/customer/{customerId}")
    public @ResponseBody
    ResponseEntity<Customer> getCustomer(@PathVariable(value = "customerId") Long customerID) throws ChangeSetPersister.NotFoundException
    {
        LOGGER.info("Searching for customer " + customerID);
        Customer customer = customerRepository.findById(customerID).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/v1/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

}
