/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
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
import com.romomo.exception.ReportVuoto;

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
        this.ordineDAO = new OrdineDAO(this.prodottoDAO);
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
        
        List<ElementoReport> risultato = ordineDAO.generaReport(numeroOrdini);

        if (risultato.size() == 0) {

            throw new ReportVuoto();
        }

        return risultato;
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

        prodottoDAO.insert(
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

        clienteDAO.insert(
            new ClienteRegistrato(
                nomeUtente, 
                password, 
                nrTelefono,
                cartaCredito
            )
        );
    }
}
