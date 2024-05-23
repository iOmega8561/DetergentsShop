package detergents.exception;

public class UtenteEsistente extends Exception {
    public UtenteEsistente() {}
    
    public UtenteEsistente(String msg) {
        super(msg);
    }

    public String getLocalizedMessage() {
        return "ERRORE ==> Questo utente esiste nella base dati!";
    }
}
