/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
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

        static public Stato getStato(int valore) {
            switch (valore) {
                case 0:
                    return Stato.ORDINATO;
                case 1:
                    return Stato.INCORSO;
                default:
                    return Stato.CONSEGNATO;
            }
        }

        Stato(int valore) {
            this.valore = valore;
        }
        
    }

	private long id;

    private float importo;

    private LocalDate data;

    private String cliente;

    private long fattorino;

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

    public long getFattorino() {
        return fattorino;
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
        long fattorino,
        List<ElementoCarrello> prodotti,
        Stato stato
    ) {
        this.id = id;
        this.importo = importo;
        this.data = data;
        this.cliente = cliente;
        this.fattorino = fattorino;
        this.prodotti = prodotti;
        this.stato = stato;
    }

}


