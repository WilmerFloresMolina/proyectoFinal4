
package projecto_final;

public class operador {

    private String valor;
    private boolean operador;

    public operador() {
        operador = false;
        valor = "";
    }

    public operador(String va, boolean op) {
        valor = va;
        operador = op;
    }

    public void setValor(String va) {
        this.valor = va;
    }

    public void setOperador(boolean op) {
        this.operador = op;
    }

    public String getValor() {
        return valor;
    }

    public boolean getOperator() {
        return operador;
    }
}
