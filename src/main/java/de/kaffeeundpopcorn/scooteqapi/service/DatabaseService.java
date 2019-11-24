package de.kaffeeundpopcorn.scooteqapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashMap;

@Service
public class DatabaseService
{
    private Logger logger = LoggerFactory.getLogger(DatabaseService.class);
    private Connection sqlConnection;

    /**
     * Connects to the server.
     */
    private void connect() throws SQLException
    {
        try
        {
            sqlConnection = DriverManager.getConnection("localhost:3306");
        }
        catch (SQLException ex)
        {
            logger.error("Failed to connect to SQL server", ex);
            throw ex;
        }
    }

    //TODO: Replace pure String concatenation with parameterized query to remove
    //      risk of SQL injection
    public ResultSet executeSearchQuery(HashMap<String, String> queryParameters) throws SQLException
    {
        connect();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(queryParameters.get("table"));
        queryBuilder.append(" WHERE ");


        queryParameters.forEach((key, value) ->
        {
            queryBuilder.append(key)
                    .append(" = ")
                    .append(value)
                    .append(" AND ");
        });

        Statement sqlQuery = sqlConnection.createStatement();
        return sqlQuery.executeQuery(queryBuilder.toString());
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
