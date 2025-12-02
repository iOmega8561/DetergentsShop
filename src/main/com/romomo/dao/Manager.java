/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Manager {

    // Singleton
    
    private static Manager INSTANCE;

    public static Manager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Manager();
        }
        return INSTANCE;
    }

    // Init
    
    private Manager() {}

    // Properties

    private String url = "jdbc:mariadb://localhost:33306/detergents?serverTimezone=UTC";

    private Connection connection;

    public Connection getConnection() throws SQLException {
        
        if (connection == null) {
            connection = DriverManager.getConnection(url, "detergents", "detergents");
        }

        return connection;
    }

    public ResultSet query(String queryStatement) throws SQLException {
        Connection conn = this.getConnection();

        PreparedStatement preparedStatement = conn.prepareStatement(queryStatement); 
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }

    public void queryVoid(String queryStatement) throws SQLException {
        Connection conn = this.getConnection();

        PreparedStatement preparedStatement = conn.prepareStatement(queryStatement); 
        preparedStatement.execute();
    }

}