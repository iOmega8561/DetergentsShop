package detergents.utility;

public class ElementoReport {

    private String cliente;
    
    private float totale;
    
    private int ordini;

    public String getCliente() {
        return cliente;
    }

    public float getTotale() {
        return totale;
    }

    public int getOrdini() {
        return ordini;
    }

    public ElementoReport(
        String cliente, 
        float totale, 
        int ordini
    ) {
        this.cliente = cliente;
        this.totale = totale;
        this.ordini = ordini;
    }
}
