/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo;

import com.romomo.boundary.BoundaryCliente;
import com.romomo.boundary.BoundaryImpiegato;
import com.romomo.utility.InputScanner;
import com.romomo.utility.Logger;
import com.romomo.utility.Logger.Level;

public class Main {

    public static void main(String[] args) {

        InputScanner scanner = new InputScanner();

        BoundaryCliente bCliente = new BoundaryCliente(scanner);
        BoundaryImpiegato bImpiegato = new BoundaryImpiegato(scanner);

        Logger.stdout(
            Level.NORMAL, 
            "DETERGENTS", 
            "Benvenuti in Detergents Shop"
        );

        while(true) {

            Logger.stdout(
                Level.NORMAL, 
                "DETERGENTS",
                "Selezionare un accesso:\n1) Cliente\n2) Impiegato\n\n"
            );

            Logger.stdout(
                Level.INFO, 
                "DETERGENTS", 
                "Digitare 0 per chiudere l'applicativo."
            );

            int scelta = scanner.nextInt(2); 

            switch (scelta) {
                case 0:
                    scanner.close();
                    System.exit(0);

                case 1:
                    bCliente.main();
                    break;

                case 2:
                    bImpiegato.main();
                    break;
            }
            
        }
    }
}
