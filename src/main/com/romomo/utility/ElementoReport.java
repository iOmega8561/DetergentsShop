/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.utility;

public class ElementoReport {

    private String cliente;
    
    private float totale;
    
    private int ordini;

    public String getCliente() {
        return cliente;
    }

    public float getTotale() {
        return totale;
    }

    public int getOrdini() {
        return ordini;
    }

    public ElementoReport(
        String cliente, 
        float totale, 
        int ordini
    ) {
        this.cliente = cliente;
        this.totale = totale;
        this.ordini = ordini;
    }
}
