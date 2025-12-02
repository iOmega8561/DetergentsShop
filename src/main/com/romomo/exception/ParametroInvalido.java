/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.exception;

public class ParametroInvalido extends Exception {
    private int idx;
    private String label;

    public int getIndex() {
        return idx;
    }

    public String getLocalizedMessage() {
        return String.format("Parametro \"%s\" non valido!", label);
    }

    public ParametroInvalido(int parameterIndex, String parameterlabel) {
        this.idx = parameterIndex;
        this.label = parameterlabel;
    }
}
