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

public class Logger {

    public enum Level {
        NORMAL,
        ERROR,
        SUCCESS,
        RESET;

        public String ansiString() {
            switch (this) {
                case NORMAL:
                    return "\u001B[33m";
            
                case ERROR:
                    return "\u001B[31m";
                
                case SUCCESS:
                    return "\u001B[32m";

                default:
                    return "\u001B[0m";
            }   
        }
    }

    private static void log(Level level, String sender, String msg, PrintStream stream) {
        stream.println(level.ansiString() + sender + " ==>" + Level.RESET.ansiString() + " " + msg);
    }

    public static void stdout(Level level, String sender, String msg) {
        log(level, sender, msg, System.out);
    }

    public static void stderr(String msg) {
        log(Level.ERROR, "ERRORE", msg, System.err);
    }
}
