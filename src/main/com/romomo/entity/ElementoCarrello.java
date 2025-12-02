/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.entity;

public class ElementoCarrello {
    private Prodotto prodotto;

    private int quantita;

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    } 

    public ElementoCarrello(
       Prodotto prodotto,
       int quantita
    ) {
       this.prodotto = prodotto;
       this.quantita = quantita;
    }

}
