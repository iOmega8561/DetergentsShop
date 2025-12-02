/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.exception;

public class ReportVuoto extends Exception {
    public String getLocalizedMessage() {
        return "Non ci sono clienti con quel numero di ordini!";
    }

    public ReportVuoto() {}
}
