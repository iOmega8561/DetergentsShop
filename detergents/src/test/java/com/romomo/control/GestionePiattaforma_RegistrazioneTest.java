/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

package com.romomo.control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import com.romomo.entity.ClienteRegistrato;
import com.romomo.exception.ParametroInvalido;
import com.romomo.exception.UtenteEsistente;

public class GestionePiattaforma_RegistrazioneTest {
    
    GestionePiattaforma contorller;

    static class TestCase extends ClienteRegistrato {
        
        TestCase(
            String nomeUtente,
            String password,
            String nrTelefono,
            String cartaCredito
        ) {
            super(nomeUtente, password, nrTelefono, cartaCredito);
        }
    }

    static Stream<TestCase> testCaseStream() {

        TestCase[] tests = {

            new TestCase(
                "paolobrosio22", 
                "hulk#buster27", 
                "3334443443", 
                "4444555566667777"
            ),

            new TestCase(
                "paolo@@brosio22", 
                "hulk#buster27", 
                "3553925732", 
                "4444444444444444"
            ),

            new TestCase(
                "paolobrooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooosio22", 
                "hulk#buster27", 
                "3553925732", 
                "4444444444444444"
            ),

            new TestCase(
                "paolobrosio22", 
                "hulk#buster27", 
                "5ASDA2#32@", 
                "4444444444444444"
            ),

            new TestCase(
                "paolobrosio22", 
                "hulk#buster27", 
                "3553925732333", 
                "4444444444444444"
            ),
            
            new TestCase(
                "paolobrosio22", 
                "hulk#buster27", 
                "3553925732", 
                "4S444#4444G44444"
            ),

            new TestCase(
                "paolobrosio22", 
                "hulk#buster27", 
                "3553925732", 
                "777"
            ),

            new TestCase(
                "paolobrosio22", 
                "hulk#busteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer27", 
                "3334443443", 
                "4444555566667777"
            ),

            new TestCase(
                "paolobrosio22", 
                "hulk#buster27", 
                "3334443443", 
                "4444555566667777"
            ),
        };

        return Arrays.stream(tests);
    }

    GestionePiattaforma_RegistrazioneTest() {
        contorller = GestionePiattaforma.getInstance();
    }

    @ParameterizedTest
    @MethodSource("testCaseStream")
    void registrazione(TestCase testCase) {

        boolean pass = false;

        try {

            contorller.registrazione(
                testCase.getNomeUtente(), 
                testCase.getPassword(),
                testCase.getNrTelefono(),
                testCase.getCartaCredito()
            );

            pass = true;
    
        } catch(ParametroInvalido error) {
            pass = true;
        } catch(UtenteEsistente error) {
            pass = true;
        } catch(Throwable error) {
            pass = false;
        }

        assertEquals(true, pass);
    }
}
