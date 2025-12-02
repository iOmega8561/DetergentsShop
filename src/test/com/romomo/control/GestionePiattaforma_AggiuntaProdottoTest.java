/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

package com.romomo.control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import com.romomo.entity.Prodotto;
import com.romomo.exception.ParametroInvalido;
import com.romomo.exception.ProdottoEsistente;

public class GestionePiattaforma_AggiuntaProdottoTest {
    
    GestionePiattaforma controller;

    static class TestCase extends Prodotto {
        
        TestCase(
            String codice,
            String nome,
            String descrizione,
            float prezzo,
            int quantita
        ) {
            super(codice, nome, descrizione, prezzo, quantita);
        }
    }

    static Stream<TestCase> testCaseStream() {

        TestCase[] tests = {

            new TestCase(
                "AEERX923", 
                "PuliMax", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                90
            ),

            new TestCase(
                "AEER@@@X92", 
                "PuliMax", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                90
            ),

            new TestCase(
                "AEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE", 
                "PuliMax", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                90
            ),

            new TestCase(
                "AEERX923", 
                "PuliMax", 
                "Bagnodocciaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
                0.67f,
                90
            ),

            new TestCase(
                "AEERX923", 
                "Puli#@Max", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                90
            ),

            new TestCase(
                "AEERX923", 
                "PuliMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                90
            ),

            new TestCase(
                "AEERX923", 
                "PuliMax", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                -0.67f,
                90
            ),

            new TestCase(
                "AEERX923", 
                "PuliMax", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                -90
            ),

            new TestCase(
                "AEERX923", 
                "PuliMax", 
                "Bagnodoccia 9 in 1 da uomo, per la cura della tua auto da uomo", 
                0.67f,
                90
            )
        };
        return Arrays.stream(tests);
    }

       GestionePiattaforma_AggiuntaProdottoTest() {
        controller = GestionePiattaforma.getInstance();
    }

    @ParameterizedTest
    @MethodSource("testCaseStream")
    void aggiuntaProdotto(TestCase testCase) {

        boolean pass = false;

        try {

            controller.aggiuntaProdotto(
                testCase.getCodice(), 
                testCase.getNome(),
                testCase.getDescrizione(),
                testCase.getPrezzo(),
                testCase.getQuantita()
            );

            pass = true;
    
        } catch(ParametroInvalido error) {
            pass = true;
        } catch(ProdottoEsistente error) {
            pass = true;
        } catch(Throwable error) {
            pass = false;
        }

        assertEquals(true, pass);
    }
}
