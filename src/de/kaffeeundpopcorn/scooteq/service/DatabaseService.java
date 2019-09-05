package de.kaffeeundpopcorn.scooteq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class DatabaseService
{
    private Logger logger = LoggerFactory.getLogger(DatabaseService.class);
    private Connection sqlConnection;

    /**
     * Connects to the server.
     */
    private void connect()
    {
        try
        {
            DriverManager.getConnection("localhost");
        }
        catch (SQLException ex)
        {
            logger.error("Failed to connect to SQL server");
        }
    }

    public void getCustomer()
    {

    }

    public void addCustomer()
    {

    }

    public void getRental()
    {

    }

    public void addRental()
    {

    }

}
