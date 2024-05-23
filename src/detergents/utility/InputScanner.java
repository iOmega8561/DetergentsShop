/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents.utility;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    private Scanner scanner;
    private PrintStream outputStream;

    public int nextInt(int max) {

        int value;

        while (true) {
            try {
                value = scanner.nextInt();
            } catch(InputMismatchException error) {
                outputStream.println("Input non valido, riprova.");
                scanner.nextLine();
                continue;
            }

            if (!(value >= 0 && value <= max)) {
                outputStream.println("Valore fuori scala, riprova.");
                continue;
            }

            break;
        }

        scanner.nextLine();
        return value;
    }

    public InputScanner(Scanner scanner, PrintStream outputStream) {
        this.scanner = scanner;
        this.outputStream = outputStream;
    }
}