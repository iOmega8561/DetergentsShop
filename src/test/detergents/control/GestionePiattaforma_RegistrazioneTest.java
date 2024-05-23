package detergents.control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import detergents.control.GestionePiattaforma;
import detergents.entity.ClienteRegistrato;
import detergents.exception.ParametroInvalido;
import detergents.exception.UtenteEsistente;

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
