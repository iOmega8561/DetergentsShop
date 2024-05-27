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

import java.util.HashMap;
import java.util.Map;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.romomo.entity.ClienteRegistrato;

public class ClienteRegistratoDAO implements Interface<String, ClienteRegistrato> {
    
    // Class-specific stubs

    private Manager manager;

    private Map<String, ClienteRegistrato> clienti;

    public Boolean check(String nomeUtente, String nrTelefono) throws SQLException {
        String statement = String.format(
            "select count(*) as rowCount from ClienteRegistrato where nomeUtente = \"%s\" or nrTelefono = \"%s\"",
            nomeUtente,
            nrTelefono
        );

        ResultSet result = manager.query(statement);

        result.next();

        if (result.getInt("rowCount") == 0) { return false; }

        return true;
    }

    // Supported interface methods

    @Override
    public Map<String, ClienteRegistrato> fetchAll() throws SQLException {

        if (clienti.size() != 0) { return clienti; }

        ResultSet result = manager.query("select * from ClienteRegistrato");

        while(result.next()) {
            String key = result.getString("nomeUtente");

            clienti.put(
                key,
                new ClienteRegistrato(
                    key,
                    result.getString("password"),
                    result.getString("nrTelefono"),
                    result.getString("cartaCredito")
                )
            );
        }
        
        return clienti;
    }

    @Override
    public void save(ClienteRegistrato entity) throws SQLException {

        String statement = String.format(
            "insert into ClienteRegistrato values (\"%s\",\"%s\",\"%s\",\"%s\")",
            entity.getNomeUtente(),
            entity.getPassword(),
            entity.getNrTelefono(),
            entity.getCartaCredito()
        );
        
        manager.queryVoid(statement);
        clienti.put(entity.getNomeUtente(), entity);
    }

    // Unsupported interface methods
    
    @Override
    public void update(ClienteRegistrato entity) {
        throw new UnsupportedOperationException("Operazione non supportata 'update'");
    }

    @Override
    public void delete(ClienteRegistrato entity) {
        throw new UnsupportedOperationException("Operazione non supportata 'delete'");
    }

    // init

    public ClienteRegistratoDAO() {
        manager = Manager.getInstance();
        clienti = new HashMap<>();
    }
}
