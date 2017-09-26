package projecto_final;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
EJEMPLO DE INPUT
9 14
1 2 4
1 8 9
2 3 9
2 8 11
3 4 7
3 9 2
3 6 4
4 5 10
4 6 15
5 6 11
6 7 2
7 8 1
7 9 6
8 9 7
PARA VERIFICACION DEL ARBOL DE EXPANSION MINIMO
9 11
1 2 4
1 8 9
2 3 9
2 8 11
3 9 2
7 8 1
7 9 6
8 9 7
4 5 10
4 6 15
5 6 11
 */
public class Kruskal {

    static final int MAX = 1005; //numero maximo de vertices
    static int padre[] = new int[MAX]; //contiene el padre del i-esimo nodo

    public Kruskal() {
    }

    static void MakeSet(int n) {
        for (int i = 1; i <= n; ++i) {
            padre[i] = i;
        }
    }

    static int Find(int x) {
        return (x == padre[x]) ? x : (padre[x] = Find(padre[x]));
    }

    static void Union(int x, int y) {
        padre[Find(x)] = Find(y);
    }

    static boolean sameComponent(int x, int y) {
        if (Find(x) == Find(y)) {
            return true;
        }
        return false;
    }

    private static int Vertic, Aristaa;

    public static void setV(int V) {
        Kruskal.Vertic = V;
    }

    public static void setE(int E) {
        Kruskal.Aristaa = E;
    }
    

    void main() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    static class Edge implements Comparator<Edge> {
        int origen;
        int destino;
        int peso;

        Edge() {
        }
        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.peso - e2.peso; //arbol de expansion minima
        }
    };

    static Edge arista[] = new Edge[MAX];
    static Edge[] exp_minima = new Edge[MAX];

    static void Kruskal_exp_minima() {
        int origen, destino, peso;
        int total = 0; //Peso total de expansion minima
        int numAristas = 0;

        MakeSet(Vertic);
        Arrays.sort(arista, 0, Aristaa, new Edge()); //ordenamos las aristas

        for (int i = 0; i < Aristaa; ++i) {
            //actual
            origen = arista[i].origen;
            destino = arista[i].destino;
            peso = arista[i].peso;

            //Verificamos si estan o no en la misma componente conexa
            if (!sameComponent(origen, destino)) {  //evitar ciclos
                total += peso;
                exp_minima[numAristas++] = arista[i];
                Union(origen, destino);
            }
        }
        
        if (Vertic - 1 != numAristas) {
            System.out.println("No existe arbol de expansion minima valido para el grafo ingresado, el grafo debe ser conexo");
            return;
        }
        System.out.println("----- Los costos encontrado contiene las siguientes aristas -----");
        for (int i = 0; i < numAristas; ++i) {
            System.out.printf("( %d , %d ) : %d\n", exp_minima[i].origen, exp_minima[i].destino, exp_minima[i].peso);
        }
        System.out.printf("El costo minimo de todas las aristas es : %d\n", total);
    }

    public void krus () {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[30mIngrese datos: ");
        Vertic = sc.nextInt();
        Aristaa = sc.nextInt();
        System.out.print("\033[31m");

        for (int i = 0; i < Aristaa; ++i) {
            arista[i] = new Edge();
            arista[i].origen = sc.nextInt();
            arista[i].destino = sc.nextInt();
            arista[i].peso = sc.nextInt();
        }
        Kruskal_exp_minima();
    }
}
