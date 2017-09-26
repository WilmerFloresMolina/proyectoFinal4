package projecto_final;

/**
 *
 * @author Wilmer
 */
public class List2 {

    private Node2 head;

    public List2(Object value) {
        this.head = new Node2(value);
    }

    public List2() {
    }

    public void insert(int posicion, Object valor) {
        if (posicion > 0) {
            if (!head.hasNext()) {
                if (posicion == 1) {
                    head.setNext(new Node2(valor));
                } else if (posicion > 1) {
                    System.err.println("Index out of bounds");
                } else {
                    Node2 temp = head;
                    head.setValue(valor);
                    head.setNext(temp);
                }
            } else {
                Node2 temp = head;
                int cont = 0;
                if (size() >= posicion) {
                    while (cont < posicion - 1) {
                        temp = temp.getNext();
                        cont++;
                    }
                    Node2 nuevo = new Node2(valor);
                    if (temp.hasNext()) {
                        Node2 temp2 = temp.getNext();
                        nuevo.setNext(temp2);
                    }
                    temp.setNext(nuevo);
                } else {
                    System.err.println("Index out of bounds");
                }
            }
        } else if (posicion == 0) {
            if (head != null) {
                Node2 temp = head;
                setHead(new Node2(valor));
                head.setNext(temp);
            } else {
                setHead(new Node2(valor));
            }
        } else {
            System.err.println("Invalid position");
        }
    }

    public int find(Object valor) {
        int contador = 0;
        Node2 temp = head;
        while (temp.hasNext()) {
            if (temp.getValue() == valor) {
                return contador;
            }
            temp = temp.getNext();
            contador++;
        }
        if (!head.hasNext()) {
            if (head.getValue() == valor) {
                return 0;
            }
        }
        return -1;
    }

    public Node2 elementAt(int posicion) {
        int contador = 0;
        Node2 temp = head;
        if (size() > posicion) {
            if (posicion == 0) {
                return head;
            }
            while (contador < posicion) {
                temp = temp.getNext();
                contador++;
            }
            return temp;
        }
        return new Node2();
    }

    public void remove(int posicion) {
        if (size() > posicion) {
            if (posicion == 0) {
                setHead(head.getNext());
            } else if (posicion == 1) {
                Node2 temp = head;
                temp = temp.getNext();
                temp = temp.getNext();
                head.setNext(temp);
            } else {
                int contador = 0;
                Node2 temp = head;
                while (contador < posicion - 1) {
                    temp = temp.getNext();
                    contador++;
                }
                Node2 temp2 = temp.getNext();
                Node2 temp3 = temp2.getNext();
                temp.setNext(temp3);
            }
        } else {
            System.err.println("Index out of bounds");
        }
    }

    public Node2 first() {
        return head;
    }

    public void concat(List2 lista) {
        Node2 temp = head;
        while (temp.hasNext()) {
            temp = temp.getNext();
        }
        temp.setNext(lista.first());
    }

    public void print() {
        if (head != null) {
            if (head.hasNext()) {
                System.out.print("[");
                Node2 temp = head;
                for (int i = 0; i < size(); i++) {
                    if (temp.hasNext()) {
                        System.out.print(temp.toString() + ",");
                        temp = temp.getNext();
                    } else {
                        System.out.print(temp.toString() + "]");
                    }
                }
            } else {
                System.out.println("[" + head.toString() + "]");
            }
        }
    }

    public int size() {
        int size = 0;
        if (head != null) {
            size++;
            Node2 temp = head;
            while (temp.hasNext()) {
                size++;
                temp = temp.getNext();
            }
        }
        return size;
    }

    public void push_back(Object value) {
        insert(size(), value);
    }

    public void setHead(Node2 head) {
        this.head = head;
    }

    public Node2 last() {
        return elementAt(size() - 1);
    }
}
