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

import detergents.control.GestionePiattaforma;
import detergents.utility.InputScanner;

public class BoundaryCliente {
    
    private static void registrazione(GestionePiattaforma controller) {

        try {

            controller.registrazione(
                "marcopisellonio", 
                "ezpassword", 
                "3427923451",
                "4444555566667777"
            );

            System.out.println("\u001B[33mBOUNDARY CLIENTE ==>\u001B[0m Utente registrato correttamente\n");

        } catch(Throwable error) {
            System.err.println(error.getLocalizedMessage());
        }
    }

    public static void main(InputScanner scanner) {

        GestionePiattaforma controller = GestionePiattaforma.getInstance();

        while(true) {

            System.out.println("\n\u001B[33mBOUNDARY CLIENTE ==>\u001B[0m Selezionare una funzionalità\n"
                               + "1) Registrazione\n"
                               + "\n"
                               + "\u001B[33mBOUNDARY CLIENTE ==>\u001B[0m Digitare 0 per tornare al menù principale\n");

            int scelta = scanner.nextInt(1); 

            switch (scelta) {
                case 0:
                    return;
                case 1:
                    BoundaryCliente.registrazione(controller);
            }
        }
    }

}
