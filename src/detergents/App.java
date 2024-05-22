/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package detergents;

import java.sql.SQLException;
import java.util.List;

import detergents.dao.ClienteRegistratoDAO;
import detergents.entity.ClienteRegistrato;;

public class App {

    public static void main(String[] args) {

        System.out.println("APPLICATION ==> Started Detergents Shop");

        ClienteRegistratoDAO crDao = new ClienteRegistratoDAO();

        try {
            List<ClienteRegistrato> clienti = crDao.fetchAll();

            for (ClienteRegistrato cliente : clienti) {
                System.out.println(cliente.getNomeUtente());
            }
            
            if (crDao.check("marcopisellonio", "3427923451")) {
                System.out.println("APPLICATION ==> user exists already");
            } else {
                crDao.save(
                    new ClienteRegistrato(
                        "marcopisellonio", 
                        "ezpassword", 
                        "3427923451",
                        "4444555566667777"
                    )
                );

                System.out.println("APPLICATION ==> user saved successfully");
            }
        } catch(SQLException error) {
            System.err.println(error.getLocalizedMessage());
        }
    }
}
