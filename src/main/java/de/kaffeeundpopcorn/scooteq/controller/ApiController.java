package de.kaffeeundpopcorn.scooteq.controller;

import de.kaffeeundpopcorn.scooteq.model.Customer;
import de.kaffeeundpopcorn.scooteq.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

import static de.kaffeeundpopcorn.scooteq.ScooteqAPI.LOGGER;

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
