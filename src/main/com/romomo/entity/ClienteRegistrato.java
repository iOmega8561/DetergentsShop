/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
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
