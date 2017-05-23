package com.csgbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gabriel on 09/05/17.
 */
public class ConnectionFactory {

    public static Connection getConnection () {
        final String DRIVER = "org.postgresql.Driver"
        ,            DATABASE = "geonames"
        ,            URL = "jdbc:postgresql://localhost:5432/"
        ,            USER = "postgres"
        ,            PASS = "postgres";

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL + DATABASE, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
