/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
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

public class JSONParser extends org.json.simple.parser.JSONParser {

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
