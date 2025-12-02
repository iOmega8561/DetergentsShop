/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.romomo.entity.ElementoCarrello;
import com.romomo.entity.Prodotto;

public class JSONCoder extends org.json.simple.parser.JSONParser {
    
    @SuppressWarnings("unchecked")
    static public String encodeProdotti(List<ElementoCarrello> prodotti) {
        JSONArray jsonArray = new JSONArray();

        for (ElementoCarrello prodotto : prodotti) {
            JSONObject obj = new JSONObject();

            obj.put("prodotto", prodotto.getProdotto().getCodice());
            obj.put("quantita", prodotto.getQuantita());

            jsonArray.add(obj);
        }

        return jsonArray.toString();
    }

    public List<ElementoCarrello> parseProdotti(
        String jsonArrayString, 
        Map<String, Prodotto> mappaProdotti
    ) {

        JSONArray prodottiJson;

        try {
            prodottiJson = (JSONArray) this.parse(jsonArrayString);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        List<ElementoCarrello> prodottiOrdine = new ArrayList<>();

        for (Object prodottoJson : prodottiJson) {
            JSONObject prodotto = (JSONObject) prodottoJson;
            long quantita = (long) prodotto.get("quantita");

            prodottiOrdine.add(
                new ElementoCarrello(
                    mappaProdotti.get(prodotto.get("prodotto")),
                    Integer.parseInt(Long.toString(quantita))
                )
            );
        }

        return prodottiOrdine;
    }
}
