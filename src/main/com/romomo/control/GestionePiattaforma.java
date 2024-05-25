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

import java.util.regex.Pattern;

import com.romomo.dao.ClienteRegistratoDAO;
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
    }

    /*
     PROPERTIES
      
     CASO D'USO: INSERIMENTO PRODOTTO
    */

    private ProdottoDAO prodottoDAO;

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
