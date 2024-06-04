/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
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