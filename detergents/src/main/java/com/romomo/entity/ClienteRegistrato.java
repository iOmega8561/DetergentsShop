/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package com.romomo.entity;

public class ClienteRegistrato {
    
    private String nomeUtente;

    private String password;

    private String nrTelefono;

    private String cartaCredito;

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getNrTelefono() {
        return nrTelefono;
    }

    public String getPassword() {
        return password;
    }

    public String getCartaCredito() {
        return cartaCredito;
    }

    public ClienteRegistrato(
        String nomeUtente, 
        String password, 
        String nrTelefono, 
        String cartaCredito
    ) {
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.nrTelefono = nrTelefono;
        this.cartaCredito = cartaCredito;
    }
}
