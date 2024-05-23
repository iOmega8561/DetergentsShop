/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents.exception;

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
