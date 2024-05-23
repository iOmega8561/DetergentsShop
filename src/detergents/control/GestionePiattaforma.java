package detergents.control;

import detergents.dao.ClienteRegistratoDAO;

import detergents.entity.ClienteRegistrato;
import detergents.exception.UtenteEsistente;

public class GestionePiattaforma {
    // Singleton
    
    private static GestionePiattaforma INSTANCE;

    public static GestionePiattaforma getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestionePiattaforma();
        }
        return INSTANCE;
    }

    // Init
    
    private GestionePiattaforma() {
        this.clienteDAO = new ClienteRegistratoDAO();
    }

    /*
     *  PROPERTIES
     * 
     *  CASO D'USO: REGISTRAZIONE
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
