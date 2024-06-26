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
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;

import com.romomo.entity.Prodotto;

public class ProdottoDAO implements Interface<String, Prodotto> {

    private Manager manager;

    private Map<String, Prodotto> prodotti;

    public Boolean check(String codice) throws SQLException {
        String statement = String.format(
            "select count(*) as rowCount from Prodotto where codice = \"%s\"",
            codice
        );

        ResultSet result = manager.query(statement);

        result.next();

        if (result.getInt("rowCount") == 0) { return false; }

        return true;
    }

    @Override
    public Map<String, Prodotto> fetch() throws SQLException {
        if (prodotti.size() != 0) { return prodotti; }

        ResultSet result = manager.query("select * from Prodotto");

        while(result.next()) {
            String key = result.getString("codice");

            prodotti.put(
                key,
                new Prodotto(
                    key,
                    result.getString("nome"),
                    result.getString("descrizione"),
                    result.getFloat("prezzo"),
                    result.getInt("quant")
                )
            );
        }
        
        return prodotti;
    }

    @Override
    public void insert(Prodotto entity) throws SQLException {

        String statement = String.format(
            Locale.US,
            "insert into Prodotto values (\"%s\",\"%s\",\"%s\", %.2f, %d)",
            entity.getCodice(),
            entity.getNome(),
            entity.getDescrizione(),
            entity.getPrezzo(),
            entity.getQuantita()
        );
        
        manager.queryVoid(statement);
        prodotti.put(entity.getCodice(), entity);
    }

    @Override
    public void update(Prodotto entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Prodotto entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
     // init

    public ProdottoDAO() {
        manager = Manager.getInstance();
        prodotti = new HashMap<>();
    }
}
