/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner implements AutoCloseable {
    private Scanner scanner;

    public String nextString() {
        return scanner.nextLine()
                    .replace("\\", "\\\\")
                    .replace("\t", "\\t")
                    .replace("\b", "\\b")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\f", "\\f")
                    .replace("\"", "\\\"");
    }

    public int nextInt(int max) {

        int value;

        while (true) {
            try {
                value = scanner.nextInt();
            } catch(InputMismatchException error) {
                Logger.stderr("Input non valido, riprova.");
                scanner.nextLine();
                continue;
            }

            if ( max >= 0 && !(value >= 0 && value <= max) ) {
                Logger.stderr("Input fuori scala, riprova.");
                continue;
            }

            break;
        }

        scanner.nextLine();
        return value;
    }

    public InputScanner() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void close() {
        this.scanner.close();
    }
}
