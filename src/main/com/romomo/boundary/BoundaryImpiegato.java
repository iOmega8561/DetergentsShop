/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package com.romomo.boundary;

import java.util.ArrayList;
import java.util.List;

import com.romomo.control.GestionePiattaforma;
import com.romomo.exception.ParametroInvalido;
import com.romomo.utility.ElementoReport;
import com.romomo.utility.InputScanner;
import com.romomo.utility.Logger;
import com.romomo.utility.Logger.Level;

public class BoundaryImpiegato {

    private InputScanner scanner;

    private GestionePiattaforma controller;

    /*
     PROPERTIES
      
     CASO D'USO: RICHIESTA REPORT
    */

    private void richiestaReport() {
        
        Logger.stdout(
            Level.NORMAL, 
            "RICHIESTA REPORT", 
            "Inserisci \"NUMERO ORDINI\""
        );

        int numeroOrdini = scanner.nextInt(-1);
        
        List<ElementoReport> risultati;

        while(true) {
            try {
                risultati = controller.richiestaReport(numeroOrdini);
                break;
            } catch (ParametroInvalido error) {
                Logger.stderr(error.getLocalizedMessage());

                Logger.stdout(
                    Level.NORMAL, 
                    "RICHIESTA REPORT", 
                    "Per favore reinserire il parametro:"
                );

                numeroOrdini = scanner.nextInt(-1);

            } catch (Throwable error) {
                Logger.stderr(error.getLocalizedMessage());
                return;
            }
        }
        
        for (ElementoReport risultato : risultati) {
            Logger.stdout(
                Level.SUCCESS, 
                "REPORT", 
                String.format(
                    "Cliente: %s; Ordini: %d; Totale: %.2f", 
                    risultato.getCliente(),
                    risultato.getOrdini(),
                    risultato.getTotale()
                )
            );
        }
    }

    /*
     PROPERTIES
      
     CASO D'USO: AGGIUNTA PRODOTTO
    */

    private void aggiuntaProdotto() {

        List<String> parameters = new ArrayList<>();

        String labels[] = {"CODICE", "NOME", "DESCRIZIONE", "PREZZO", "QUANTITA'"};

        for (String label : labels) {

            Logger.stdout(
                Level.NORMAL, 
                "AGGIUNTA PRODOTTO", 
                String.format("Inserisci \"%s\":", label)
            );
   
            parameters.add(scanner.nextString());
        }

        while (true) {

            try {

                float prezzo;

                try {
                    prezzo = Float.parseFloat(parameters.get(3));
                } catch(NumberFormatException error) { 
                    throw new ParametroInvalido(3, "PREZZO"); 
                }

                int quantita;

                try {
                    quantita = Integer.parseInt(parameters.get(4));
                } catch(NumberFormatException error) { 
                    throw new ParametroInvalido(4, "QUANTITA'"); 
                }

                controller.aggiuntaProdotto(
                    parameters.get(0), 
                    parameters.get(1), 
                    parameters.get(2),
                    prezzo,
                    quantita
                );

                break;

            } catch(ParametroInvalido error) {
                Logger.stderr(error.getLocalizedMessage());

                Logger.stdout(
                    Level.NORMAL, 
                    "AGGIUNTA PRODOTTO", 
                    "Per favore reinserire il parametro:"
                );

                parameters.set(error.getIndex(), scanner.nextString());

            } catch(Throwable error) {
                Logger.stderr(error.getLocalizedMessage());
                return;
            }
        }
            
        Logger.stdout(
            Level.SUCCESS, 
            "AGGIUNTA PRODOTTO", 
            "Prodotto aggiunto correttamente!"
        );
    }
    
    /*
     PROPERTIES
      
     CASO D'USO: RICHIESTA REPORT / AGGIUNTA PRODOTTO
    */

    public void main() {

        while(true) {

            Logger.stdout(
                Level.NORMAL, 
                "BOUNDARY IMPIEGATO",
                "Selezionare una funzionalità:\n1) Aggiunta prodotto\n2) Richiesta report\n"
            );

            Logger.stdout(
                Level.INFO, 
                "BOUNDARY IMPIEGATO", 
                "Digitare 0 per tornare al menù principale."
            );

            int scelta = scanner.nextInt(2); 

            switch (scelta) {
                case 0:
                    return;
                case 1:
                    aggiuntaProdotto();
                    break;
                case 2:
                    richiestaReport();
                    break;
            }
        }
    }

    // Init

    public BoundaryImpiegato(InputScanner scanner) {
        this.scanner = scanner;
        this.controller = GestionePiattaforma.getInstance();
    }
}
