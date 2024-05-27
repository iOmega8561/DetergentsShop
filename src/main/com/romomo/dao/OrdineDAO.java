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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.romomo.entity.Ordine;
import com.romomo.utility.ElementoReport;

public class OrdineDAO implements Interface<Ordine> {
	
	private Manager manager;
	
	private List<Ordine> ordini;
    
    public List<ElementoReport> generaReport(int numeroOrdini) throws SQLException {
        String statement = String.format(
            "select O.cliente as Cliente, count(O.id) as NumeroOrdini, sum(O.totale) as TotaleSpeso from Ordine O group by O.cliente having count(O.id) >= %d order by NumeroOrdini;",
            numeroOrdini
        );

        List<ElementoReport> risultati = new ArrayList<>();

        ResultSet risultatoQuery = manager.query(statement);

        while(risultatoQuery.next()) {
            risultati.add(
                new ElementoReport(
                    risultatoQuery.getString("Cliente"), 
                    risultatoQuery.getFloat("TotaleSpeso"),
                    risultatoQuery.getInt("NumeroOrdini")
                )
            );
        }

        return risultati;
    }

    @Override
    public List<Ordine> fetchAll() throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'fetchAll'");
    }

    @Override
    public void save(Ordine entity) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Ordine entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Ordine entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    public OrdineDAO() {
        manager = Manager.getInstance();
        ordini = new ArrayList<>();
    }

}