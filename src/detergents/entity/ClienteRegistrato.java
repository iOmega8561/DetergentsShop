package detergents.entity;

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
