/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import detergents.entity.ClienteRegistrato;

public class ClienteRegistratoDAO implements Interface<ClienteRegistrato> {
    
    // Class-specific stubs

    private Manager manager;

    private List<ClienteRegistrato> clienti;

    public Boolean check(String nomeUtente, String nrTelefono) {
        String statement = String.format(
            "select count(*) as rowCount from ClienteRegistrato where nomeUtente = \"%s\" or nrTelefono = \"%s\"",
            nomeUtente,
            nrTelefono
        );

        try(ResultSet result = manager.query(statement);) { 

            result.next();

            if (result.getInt("rowCount") == 0) { return false; }

        } catch(SQLException error) {
            System.err.println(error.getLocalizedMessage());
        }

        return true;
    }

    // Supported interface methods

    @Override
    public List<ClienteRegistrato> fetchAll() {

        if (clienti.size() != 0) { return clienti; }

        try(ResultSet result = manager.query("select * from ClienteRegistrato");) {

            while(result.next()) {
                clienti.add(
                    new ClienteRegistrato(
                        result.getString("nomeUtente"),
                        result.getString("password"),
                        result.getString("nrTelefono"),
                        result.getString("cartaCredito")
                    )
                );
            }

        } catch(SQLException error) {
            System.err.println(error.getLocalizedMessage());
        }

        return clienti;
    }

    @Override
    public void save(ClienteRegistrato entity) {

        String statement = String.format(
            "insert into ClienteRegistrato values (\"%s\",\"%s\",\"%s\",\"%s\")",
            entity.getNomeUtente(),
            entity.getPassword(),
            entity.getNrTelefono(),
            entity.getCartaCredito()
        );


        try {
            manager.queryVoid(statement);
            clienti.add(entity);
        } catch(SQLException error) {
            System.err.println(error.getLocalizedMessage());
        }
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
        clienti = new ArrayList<>();
    }
}
