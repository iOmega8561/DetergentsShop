/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.utility;

import java.io.PrintStream;

public class Logger {

    public enum Level {
        NORMAL("\u001B[33m"),
        ERROR("\u001B[31m"),
        SUCCESS("\u001B[32m"),
        INFO("\u001B[36m"),
        RESET("\u001B[0m");

        private String ansiColor;

        public String getColor() {
            return ansiColor;
        }

        Level(String ansiColor) {
            this.ansiColor = ansiColor;
        }
    }

    private static void log(Level level, String sender, String msg, PrintStream stream) {
        stream.println(level.getColor() + sender + " ==>" + Level.RESET.getColor() + " " + msg);
    }

    public static void stdout(Level level, String sender, String msg) {
        log(level, sender, msg, System.out);
    }

    public static void stderr(String msg) {
        log(Level.ERROR, "ERRORE", msg, System.err);
    }
}
