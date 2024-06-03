/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package com.romomo.entity;

import java.time.LocalDate;
import java.util.List;

public class Ordine {
	
    public enum Stato {
        ORDINATO(0),
        INCORSO(1),
        CONSEGNATO(2);

        private int valore;

        public int getValore() {
            return valore;
        }

        Stato(int valore) {
            this.valore = valore;
        }
        
    }

	private long id;

    private float importo;

    private LocalDate data;

    private String cliente;

    private List<ElementoCarrello> prodotti;

    private Stato stato;

    public long getId() {
        return id;
    }

    public float getImporto() {
        return importo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ElementoCarrello> getProdotti() {
        return prodotti;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Ordine(
        long id,
        float importo,
        LocalDate data,
        String cliente,
        List<ElementoCarrello> prodotti,
        Stato stato
    ) {
        this.id = id;
        this.importo = importo;
        this.data = data;
        this.cliente = cliente;
        this.prodotti = prodotti;
        this.stato = stato;
    }

}


