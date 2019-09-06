package de.kaffeeundpopcorn.scooteq.controller;

import de.kaffeeundpopcorn.scooteq.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Sebastian Burger
 * File Controller for the WKZ REST api.
 * This class contains the get and post mappings.
 */
@RestController
public class ApiController
{

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    static
    {
        logger.debug("LOGGING STARTED");
    }

    @Autowired
    private DatabaseService databaseService;

    /**
     * GET Mapping for /health
     *
     * @return A ResponseEntity with Status OK
     * FIXME: Doesn't actually do a health check :)
     */
    @GetMapping("/health")
    public @ResponseBody
    RedirectView health()
    {
        return new RedirectView("https://http.cat/200.jpg");
    }

    // TODO: Add rental post and get
    @PostMapping("/rental")
    public @ResponseBody ResponseEntity<String> postRental()
    {
        return ResponseEntity.notFound().build();
    }

    // TODO: Add customer post and get
    @PostMapping("/customer")
    public @ResponseBody ResponseEntity<String> postCustomer()
    {
        return null;
    }

}
