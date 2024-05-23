/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents.control;

import detergents.dao.ClienteRegistratoDAO;
import detergents.entity.ClienteRegistrato;
import detergents.exception.UtenteEsistente;

public class GestionePiattaforma {
    
    private static GestionePiattaforma INSTANCE;

    public static GestionePiattaforma getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestionePiattaforma();
        }
        return INSTANCE;
    }
    
    private GestionePiattaforma() {
        this.clienteDAO = new ClienteRegistratoDAO();
    }

    /*
     PROPERTIES
      
     CASO D'USO: REGISTRAZIONE
    */

    private ClienteRegistratoDAO clienteDAO;

    public void registrazione(
        String nomeUtente,
        String password,
        String nrTelefono,
        String cartaCredito
    ) throws Throwable {

        if (clienteDAO.check(nomeUtente, nrTelefono)) {
            throw new UtenteEsistente();
        }

        clienteDAO.save(
            new ClienteRegistrato(
                nomeUtente, 
                password, 
                nrTelefono,
                cartaCredito
            )
        );
    }
}
