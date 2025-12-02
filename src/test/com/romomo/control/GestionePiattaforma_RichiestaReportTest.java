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

import com.romomo.exception.ParametroInvalido;
import com.romomo.exception.ReportVuoto;

public class GestionePiattaforma_RichiestaReportTest {
    
    GestionePiattaforma controller;

    static class TestCase {
        
        private int numeroOrdini;

        public int getNumeroOrdini() {
            return numeroOrdini;
        }

        TestCase(int numeroOrdini) {
            this.numeroOrdini = numeroOrdini;
        }
    }

    static Stream<TestCase> testCaseStream() {

        TestCase[] tests = {
            new TestCase(2),
            new TestCase(2000),
            new TestCase(900)
        };

        return Arrays.stream(tests);
    }

    GestionePiattaforma_RichiestaReportTest() {
        controller = GestionePiattaforma.getInstance();
    }

    @ParameterizedTest
    @MethodSource("testCaseStream")
    void aggiuntaProdotto(TestCase testCase) {

        boolean pass = false;

        try {

            controller.richiestaReport(
                testCase.getNumeroOrdini()
            );

            pass = true;
    
        } catch(ParametroInvalido error) {
            pass = true;

        } catch(ReportVuoto error) {
            pass = true;

        } catch(Throwable error) {
            pass = false;
        }

        assertEquals(true, pass);
    }
}
