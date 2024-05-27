/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package com.romomo.control;

import java.util.List;
import java.util.regex.Pattern;

import com.romomo.utility.ElementoReport;
import com.romomo.dao.ClienteRegistratoDAO;
import com.romomo.dao.OrdineDAO;
import com.romomo.dao.ProdottoDAO;
import com.romomo.entity.ClienteRegistrato;
import com.romomo.entity.Prodotto;
import com.romomo.exception.ParametroInvalido;
import com.romomo.exception.UtenteEsistente;
import com.romomo.exception.ProdottoEsistente;

public class GestionePiattaforma {
    
    private static GestionePiattaforma INSTANCE;

    public static GestionePiattaforma getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestionePiattaforma();
        }
        return INSTANCE;
    }
    
    private GestionePiattaforma() {
        this.clienteDAO = new ClienteRegistratoDAO();
        this.prodottoDAO = new ProdottoDAO();
        this.ordineDAO = new OrdineDAO();
    }
    
    /*
     PROPERTIES
      
     CASO D'USO: RICHIESTA REPORT
    */

    private OrdineDAO ordineDAO;

    public List<ElementoReport> richiestaReport(int numeroOrdini) throws Throwable {
        
        if (numeroOrdini > 1000 ||
            numeroOrdini <= 0) {

            throw new ParametroInvalido(0,"NUMERO ORDINI");
        }
        
        return ordineDAO.generaReport(numeroOrdini);
    }

    /*
     PROPERTIES
      
     CASO D'USO: INSERIMENTO PRODOTTO
    */

    private ProdottoDAO prodottoDAO;

    public void aggiuntaProdotto(
        String codice,
        String nome,
        String descrizione,
        float prezzo,
        int quantita
    ) throws Throwable {

        Pattern noSpecials = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);

        if (noSpecials.matcher(codice).find() || 
            codice.length() > 255 ||
            codice.length() <= 0) {

            throw new ParametroInvalido(0, "CODICE");
        }
        
        if (noSpecials.matcher(nome).find() || 
            nome.length() > 255 ||
            nome.length() <= 0) {

            throw new ParametroInvalido(1, "NOME");
        }

        if (descrizione.length() > 255 ||
            descrizione.length() <= 0) {

            throw new ParametroInvalido(2,"DESCRIZIONE");
        }

        if (prezzo > 1000 ||
            prezzo <= 0) {

            throw new ParametroInvalido(3,"PREZZO");
        }

        if (quantita > 1000 ||
            quantita <= 0) {

            throw new ParametroInvalido(4,"QUANTITA'");
        }

        if (prodottoDAO.check(codice)) {
            throw new ProdottoEsistente();
        }

        prodottoDAO.save(
            new Prodotto(
                codice, 
                nome, 
                descrizione,
                prezzo,
                quantita
            )
        );
    }

    /*
     PROPERTIES
      
     CASO D'USO: REGISTRAZIONE
    */

    private ClienteRegistratoDAO clienteDAO;

    public void registrazione(
        String nomeUtente,
        String password,
        String nrTelefono,
        String cartaCredito
    ) throws Throwable {

        Pattern noSpecials = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Pattern numeric = Pattern.compile("[^0-9]");

        if (noSpecials.matcher(nomeUtente).find() || 
            nomeUtente.length() > 255 ||
            nomeUtente.length() <= 0) {

            throw new ParametroInvalido(0, "NOME UTENTE");
        }

        if (password.length() > 255 ||
            password.length() <= 0) {

            throw new ParametroInvalido(1, "PASSWORD");
        }

        if (numeric.matcher(nrTelefono).find() || 
            nrTelefono.length() != 10) {
            
            throw new ParametroInvalido(2, "NUMERO CELLULARE");
        }

        if (numeric.matcher(cartaCredito).find() ||
            cartaCredito.length() != 16) {
            
            throw new ParametroInvalido(3, "CARTA DI CREDITO");
        }

        if (clienteDAO.check(nomeUtente, nrTelefono)) {
            throw new UtenteEsistente();
        }

        clienteDAO.save(
            new ClienteRegistrato(
                nomeUtente, 
                password, 
                nrTelefono,
                cartaCredito
            )
        );
    }
}
