/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.boundary;

import java.util.ArrayList;
import java.util.List;

import com.romomo.control.GestionePiattaforma;
import com.romomo.exception.ParametroInvalido;
import com.romomo.utility.InputScanner;
import com.romomo.utility.Logger;
import com.romomo.utility.Logger.Level;

public class BoundaryCliente {
    
    private InputScanner scanner;

    private GestionePiattaforma controller;

    private void registrazione() {

        List<String> parameters = new ArrayList<>();

        String labels[] = {"NOME UTENTE", "PASSWORD", "NUMERO CELLULARE", "CARTA DI CREDITO"};

        for (String label : labels) {

            Logger.stdout(
                Level.NORMAL, 
                "REGISTRAZIONE", 
                String.format("Inserisci \"%s\":", label)
            );

            parameters.add(scanner.nextString());
        }

        while (true) {
            try {
                controller.registrazione(
                    parameters.get(0), 
                    parameters.get(1), 
                    parameters.get(2),
                    parameters.get(3)
                );

                break;

            } catch(ParametroInvalido error) {
                Logger.stderr(error.getLocalizedMessage());

                Logger.stdout(
                    Level.NORMAL, 
                    "REGISTRAZIONE", 
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
            "REGISTRAZIONE", 
            "Registrazione avvenuta con successo!"
        );
    }

    public void main() {

        while(true) {

            Logger.stdout(
                Level.NORMAL, 
                "BOUNDARY CLIENTE",
                "Selezionare una funzionalità:\n1) Registrazione\n\n"
            );

            Logger.stdout(
                Level.INFO, 
                "BOUNDARY CLIENTE", 
                "Digitare 0 per tornare al menù principale."
            );

            int scelta = scanner.nextInt(1); 

            switch (scelta) {
                case 0:
                    return;
                case 1:
                    registrazione();
                    break;
            }
        }
    }

    public BoundaryCliente(InputScanner scanner) {
        this.scanner = scanner;
        this.controller = GestionePiattaforma.getInstance();
    }
}
