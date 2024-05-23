package detergents.exception;

public class ParametroInvalido extends Exception {
    private int idx;
    private String label;

    public int getIndex() {
        return idx;
    }

    public String getLocalizedMessage() {
        return String.format("\u001B[31mERRORE ==>\u001B[0m Parametro \"%s\" non valido!", label);
    }

    public ParametroInvalido(int parameterIndex, String parameterlabel) {
        this.idx = parameterIndex;
        this.label = parameterlabel;
    }
}
