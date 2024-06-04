/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
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
