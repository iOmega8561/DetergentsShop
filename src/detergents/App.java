/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents;

import java.util.Scanner;

import detergents.boundary.BoundaryCliente;
import detergents.utility.InputScanner;

public class App {

    public static void main(String[] args) {

        System.out.println("APPLICAZIONE ==> Benvenuti in Detergents Shop");

        Scanner _scanner = new Scanner(System.in);
        InputScanner scanner = new InputScanner(_scanner, System.err);

        while(true) {
            System.out.println("\nAPPLICAZIONE ==> Selezionare l'accesso \n"
                             + "1) Cliente\n"
                             + "2) Impiegato\n"
                             + "\n"
                             + "APPLICAZIONE ==> Digitare 0 per chiudere l'applicativo\n");

            int scelta = scanner.nextInt(2); 

            switch (scelta) {
                case 0:
                    _scanner.close();
                    System.exit(0);
                case 1:
                    BoundaryCliente.main();
                    break;
                case 2:
                    // To do
                    System.exit(0);
            }
            
        }
    }
}
