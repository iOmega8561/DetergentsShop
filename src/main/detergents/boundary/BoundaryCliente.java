/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents.boundary;

import java.util.ArrayList;
import java.util.List;

import detergents.control.GestionePiattaforma;
import detergents.exception.ParametroInvalido;
import detergents.utility.InputScanner;
import detergents.utility.Logger;
import detergents.utility.Logger.Level;

public class BoundaryCliente {
    
    private static void registrazione(InputScanner scanner, GestionePiattaforma controller) {

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

    public static void main(InputScanner scanner) {

        GestionePiattaforma controller = GestionePiattaforma.getInstance();

        while(true) {

            Logger.stdout(
                Level.NORMAL, 
                "BOUNDARY CLIENTE",
                "Selezionare una funzionalità:\n1) Registrazione\n\n"
            );

            Logger.stdout(
                Level.INFO, 
                "BOUNDARY CLIENTE", 
                "Digitare 0 per tornare al menù principale.\n"
            );

            int scelta = scanner.nextInt(1); 

            switch (scelta) {
                case 0:
                    return;
                case 1:
                    BoundaryCliente.registrazione(scanner, controller);
            }
        }
    }

}
