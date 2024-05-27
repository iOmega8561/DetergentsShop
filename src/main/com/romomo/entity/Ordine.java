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
        Stato stato
    ) {
        this.id = id;
        this.importo = importo;
        this.data = data;
        this.cliente = cliente;
        this.stato = stato;
    }

}


