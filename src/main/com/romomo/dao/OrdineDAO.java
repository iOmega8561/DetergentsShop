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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.romomo.entity.Ordine;

public class OrdineDAO implements Interface<Ordine> {
	
	private Manager manager;
	
	private List<Ordine> ordini;
        
    public Boolean generaReport(String numeroOrdini) throws SQLException {
        String statement = String.format(
            "select count(*) as rowCount from Ordine where numeroOrdine = \"%s\"",
            numeroOrdini
        );
        
        ResultSet result = manager.query(statement);

        result.next();

        if (result.getInt("rowCount") == 0) { return false; }

        return true;
    }
    
    @Override
    public List<Ordine> fetchAll() throws SQLException {

        if (ordini.size() != 0) { return ordini; }

        ResultSet result = manager.query("select * from Ordine");

        while(result.next()) {
            ordini.add(
                new Ordine(
                    result.getString("numeroOrdine"),
                )
            );
        }
        
        return ordini;
    }
    
    @Override
    public void save(Ordine entity) throws SQLException {
        String statement = String.format(
            "insert into Ordine values (\"%s\")",
            entity.getNumeroOrdini()
        );
        
        manager.queryVoid(statement);
        ordini.add(entity);
    }

    @Override
    public void update(Ordine entity) {
        throw new UnsupportedOperationException("Operazione non supportata 'update'");
    }

    @Override
    public void delete(Ordine entity) {
        throw new UnsupportedOperationException("Operazione non supportata 'delete'");
    }
    
    public OrdineDAO() {
        manager = Manager.getInstance();
        ordini = new ArrayList<>();
    }
}
