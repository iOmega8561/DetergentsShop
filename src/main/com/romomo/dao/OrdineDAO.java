/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.romomo.entity.Ordine;
import com.romomo.entity.Prodotto;
import com.romomo.entity.Ordine.Stato;
import com.romomo.utility.ElementoReport;
import com.romomo.utility.JSONCoder;

public class OrdineDAO implements Interface<Long, Ordine> {

	private Manager manager;
	
    private ProdottoDAO prodottoDAO;

    private Map<Long, Ordine> ordini;

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
    public Map<Long, Ordine> fetch() throws SQLException {
        if (ordini.size() != 0) { return ordini; }

        Map<String, Prodotto> mappaProdotti = prodottoDAO.fetch();

        JSONCoder jsonParser = new JSONCoder();

        ResultSet result = manager.query("select * from Ordine");

        while(result.next()) {

            long key = result.getLong("id");

            ordini.put(
                key,
                new Ordine(
                    key,
                    result.getFloat("totale"),
                    result.getDate("data").toLocalDate(),
                    result.getString("cliente"),
                    result.getLong("fattorino"),
                    jsonParser.parseProdotti(result.getString("prodotti"), mappaProdotti),
                    Stato.getStato(result.getInt("stato"))
                )
            );
        }
        
        return ordini;
    }

    @Override
    public void insert(Ordine entity) throws SQLException {        

        String statement = String.format(
            Locale.US,
            "insert into Ordine (data, totale, stato, prodotti, cliente, fattorino) values (\"%s\", %.2f, %d,\"%s\",\"%s\", %d) returning id",
            entity.getData().toString(),
            entity.getImporto(),
            entity.getStato().getValore(),
            JSONCoder.encodeProdotti(entity.getProdotti()).replace("\"", "\\\""),
            entity.getCliente(),
            entity.getFattorino()
        );
        
        ResultSet result = manager.query(statement); result.next();

        long key = result.getLong("id");

        ordini.put(
            key, 
            new Ordine(
                key, 
                entity.getImporto(), 
                entity.getData(), 
                entity.getCliente(), 
                entity.getFattorino(), 
                entity.getProdotti(), 
                entity.getStato()
            )
        );
    }

    @Override
    public void update(Ordine entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Ordine entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    public OrdineDAO(ProdottoDAO prodottoDAO) {
        this.manager = Manager.getInstance();
        this.prodottoDAO = prodottoDAO;
        this.ordini = new HashMap<>();
    }

}
