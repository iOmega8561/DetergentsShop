/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents.utility;

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
