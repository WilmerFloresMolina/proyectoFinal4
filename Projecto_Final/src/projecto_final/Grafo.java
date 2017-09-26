
package projecto_final;

public class Grafo {

    String nombre;
    private List2 nodos;

    public Grafo(List2 nodos) {
        this.nodos = nodos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Grafo() {
        nodos = new List2();
    }

    public List2 getNodos() {
        return nodos;
    }

    public void setNodos(List2 nodos) {
        this.nodos = nodos;
    }

    public void addVertex(Node2 vertex) {
        nodos.push_back(vertex);
    }

    public void getaristas() {
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                System.out.print(nodos.elementAt(i).getAristas().elementAt(j).toString() + " "+ nodos.elementAt(i).getAristas().elementAt(j).getColor() +"\n");
            }
            System.out.println("");
        }

    }

    public void pintar() {

        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                if (j % 2 == 0) {
                    nodos.elementAt(i).getAristas().elementAt(j).setColor("\033[34mAzul");
                } else {
                    nodos.elementAt(i).getAristas().elementAt(j).setColor("\033[31mRojo");
                }

            }
        }
    }

    public void bicoloreable() {
        if (nodos.elementAt(0).getAristas().elementAt(0).getColor().equals(nodos.elementAt(0).getAristas().elementAt(nodos.elementAt(0).getAristas().size() - 1).getColor())) {
            //System.out.println(nodos.elementAt(0).getAristas().elementAt(0).getColor());
           //System.out.println(nodos.elementAt(0).getAristas().elementAt(nodos.elementAt(0).getAristas().size() - 1).getColor());
            System.out.println("No es Bicoloreable");
        } else {
           // System.out.println(nodos.elementAt(0).getAristas().elementAt(0).getColor());
           // System.out.println(nodos.elementAt(0).getAristas().elementAt(nodos.elementAt(0).getAristas().size() - 1).getColor());
            System.out.println("Bicoloreable");
        }

    }

    public void addEdge(Node2 vertex, Arista edge) {
        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.elementAt(i).getID()) {
                nodos.elementAt(i).getAristas().push_back(edge);
                break;
            }
        }
    }

    public Node2 getVertex(int posicion) {
        return nodos.elementAt(posicion);
    }

    public List2 getadjacentVertices(Node2 vertex) {
        List2 adjacent = new List2();
        for (int i = 0; i < vertex.getAristas().size(); i++) {
            adjacent.push_back(((Arista) vertex.getAristas().elementAt(i).getValue()).getNodoFinal());
            // System.out.println(((Arista) vertex.getAristas().elementAt(i).getValue()).getNodoFinal());
        }
        return adjacent;
    }

    public double getadjacentVertices2(Node2 vertex) {
        double eficiencia = 0;
        for (int i = 0; i < vertex.getAristas().size(); i++) {
            eficiencia = eficiencia + ((Arista) vertex.getAristas().elementAt(i).getValue()).getTamano();
        }
        // ((Arista)vertex.getAristas().elementAt(0).getValue()).getTamano();
        return eficiencia;
    }

    public boolean isAdjacent(Node2 vertex, Node2 vertex2) {
        boolean adjacent = false;
        for (int i = 0; i < vertex.getAristas().size(); i++) {
            if (((Arista) vertex.getAristas().elementAt(i).getValue()).getNodoFinal().getID() == vertex2.getID()) {
                adjacent = true;
            }
        }
        return adjacent;
    }

    public Node2 First() {
        return getVertex(0);
    }

    public void removeVertex(int posicion) {
        int nodeIndex = -1;

        for (int i = 0; i < nodos.size(); i++) {
            if (nodos.elementAt(posicion).getID() == nodos.elementAt(i).getID()) {
                nodeIndex = i;
                break;
            }
        }
        if (nodeIndex != -1) {
            for (int i = 0; i < nodos.size(); i++) {
                for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                    if (((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoFinal().getID()
                            == nodos.elementAt(nodeIndex).getID()) {
                        removeEdge(nodos.elementAt(i), ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()));
                    } else if (((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoInicial().getID()
                            == nodos.elementAt(nodeIndex).getID()) {
                        removeEdge(nodos.elementAt(nodeIndex), ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()));
                    }
                }
            }

            nodos.remove(nodeIndex);

            for (int i = 0; i < nodos.size(); i++) {
                nodos.elementAt(i).setID(i);
            }
        } else {
            System.err.println("Index out of bounds");
        }
    }

    public void removeEdge(Node2 vertex, Arista edge) {
        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.elementAt(i).getID()) {
                for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                    if (((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoInicial().getID()
                            == edge.getNodoInicial().getID()
                            && ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoFinal().getID()
                            == edge.getNodoFinal().getID()) {
                        nodos.elementAt(i).getAristas().remove(j);
                        break;

                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += "" + "grafo:\n";
        for (int i = 0; i < nodos.size(); i++) {
            retorno += i + ": " + nodos.elementAt(i).toString() + "\n";
            for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                retorno += "       " + j + ": " + nodos.elementAt(i).getAristas().elementAt(j).getValue().toString() + "\n";
            }
        }
        return nombre;
    }

    public int[][] Floyd() {
        final int infinito = 999;
        double[][] matrizA;
        double[][] matrizC = new double[nodos.size()][nodos.size()];
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                if (i == j) {
                    matrizC[i][j] = infinito;
                } else {
                    matrizC[i][j] = nodos.elementAt(j).getID();
                }
            }
        }
        matrizA = generarAdyacencia();
        matrizC = caminos(matrizA, matrizC);
        int[][] path = new int[nodos.size()][nodos.size()];
        for (int i = 0; i < nodos.size(); i++) {
            path[i][i] = 0;
        }

        for (int k = 0; k < nodos.size(); k++) {
            for (int i = 0; i < nodos.size(); i++) {
                for (int j = 0; j < nodos.size(); j++) {
                    int dt = path[i][k] + path[k][j];
                    if (path[i][j] > dt) {
                        path[i][j] = dt;
                    }
                }
            }
        }

        return path;
    }

    public double[][] generarAdyacencia() {
        final int infinito = 999;
        double[][] matriz = new double[nodos.size()][nodos.size()];
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                if (nodos.elementAt(i).getAristas().elementAt(j).getValue() != null) {
                    matriz[nodos.elementAt(i).getID()][((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoFinal().getID()] = ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getTamano();
                    System.out.println(matriz[nodos.elementAt(i).getID()][((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoFinal().getID()] = ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getTamano());
                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    if (i == j) {
                        matriz[i][j] = 0;
                    } else {
                        matriz[i][j] = infinito;
                    }
                }
            }
        }
        return matriz;
    }

    public double[][] caminos(double[][] matrizA, double[][] matrizC) {
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                for (int k = 0; k < nodos.size(); k++) {
                    if (matrizA[i][k] + matrizA[k][j] < matrizA[i][j]) {
                        matrizA[i][j] = matrizA[i][k] + matrizA[k][j];
                        matrizC[i][j] = k;
                    }
                }
            }
        }
        return matrizC;
    }

    public Grafo camino(int i, int j, double[][] caminos, Grafo temp) {
        if (i == j) {
            temp.addVertex(this.nodos.elementAt(j));
            return temp;
        }
        temp.addVertex(this.nodos.elementAt(j));
        temp = camino(i, (int) caminos[j][i], caminos, temp);
        return temp;
    }

    //Prim
}
