
package projecto_final;

public class Node2 {

    private Object value;
    private Node2 next;
    private int ID;
    private boolean visitado = false;
    private List2 aristas = new List2();
    private String Color = "";

    public Node2(Object value) {
        this.value = value;
    }

    public Node2(Object value, int id) {
        this.value = value;
        this.ID = id;
    }

    public Node2(Object value, Node2 next, int ID) {
        this.value = value;
        this.next = next;
        this.ID = ID;
    }

    public Node2() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        return false;
    }

    public List2 getAristas() {
        return aristas;
    }

    public void setAristas(List2 relations) {
        this.aristas = relations;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String toString() {
        return "" + value + "";
    }

}
