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
