/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.exception;

public class UtenteEsistente extends Exception {
    public String getLocalizedMessage() {
        return "Questo utente esiste nella base dati!";
    }

    public UtenteEsistente() {}
}
