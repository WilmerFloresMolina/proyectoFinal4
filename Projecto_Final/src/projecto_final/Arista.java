
package projecto_final;

public class Arista {

    private double tamano;
    private Node2 nodoInicial;
    private Node2 nodoFinal;

    public Arista() {
    }

    public Arista(double tamano, Node2 nodoInicial, Node2 nodoFinal) {
        this.tamano = tamano;
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public Node2 getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(Node2 nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public Node2 getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Node2 nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    @Override
    public String toString() {
        return "\033[30mlongitud " + "\033[31m" + tamano + " " + "\033[30m(" + "\033[34m" + nodoInicial + "\033[30m)" + "\033[30m hacia " + "(" + "\033[34m" + nodoFinal + "\033[30m)" + "";
    }
}
