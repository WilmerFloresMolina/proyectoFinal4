/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_final;

import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class Prim {

    public Prim() {
    }

    public static int[][] shortestpath(int[][] adj, int[][] path) {

        int n = adj.length;
        int[][] ans = new int[n][n];

        // Implementar el algoritmo en una matriz de copia de modo que la adyacencia no es
        //destruido.
        copy(ans, adj);

        // Calcular rutas sucesivamente a través de una mejor k vértices.
        for (int k = 0; k < n; k++) {

            // Es así que entre cada par de puntos posibles.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (ans[i][k] + ans[k][j] < ans[i][j]) {
                        ans[i][j] = ans[i][k] + ans[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        // Devuelva la matriz camino más corto.
        return ans;
    }

    public static void copy(int[][] a, int[][] b) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    // Devuelve el menor de a y b.
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public void main() {
        Scanner stdin = new Scanner(System.in);

        // Pruebas fuera con algoritmo gráfico mostrado en clase.
        /*
        0, 3, 0, 2, 0
        3, 0, 4, 0, 1
        0, 4, 0, 0, 0
        2, 0, 0, 0, 0
        0, 1, 0, 0, 0*/
        int[][] m = new int[5][5];
        m[0][0] = 0;
        m[0][1] = 3;
        m[0][2] = 8;
        m[0][3] = 10000;
        m[0][4] = -4;
        m[1][0] = 10000;
        m[1][1] = 0;
        m[1][2] = 10000;
        m[1][3] = 1;
        m[1][4] = 7;
        m[2][0] = 10000;
        m[2][1] = 4;
        m[2][2] = 0;
        m[2][3] = 10000;
        m[2][4] = 10000;
        m[3][0] = 2;
        m[3][1] = 10000;
        m[3][2] = -5;
        m[3][3] = 0;
        m[3][4] = 10000;
        m[4][0] = 10000;
        m[4][1] = 10000;
        m[4][2] = 10000;
        m[4][3] = 6;
        m[4][4] = 0;
        System.out.println("Desea probar ya con una matriz prexistente[s/n ]");
        String opcion = stdin.next().toLowerCase();
        if (opcion.equals("s")) {

        } else {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    System.out.println("Ingrese el numero");
                    System.out.println("("+i+")("+j+")");
                    m[i][j] = stdin.nextInt();
                }
            }
        }

        int[][] shortpath;
        int[][] path = new int[5][5];

        // Inicializar con el vértice anterior para cada borde. -1 indica
        // no tal vertice.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (m[i][j] == 10000) {
                    path[i][j] = -1;
                } else {
                    path[i][j] = i;
                }
            }
        }

        // Esto significa que no tiene que ir a ninguna parte para ir de i a i.
        for (int i = 0; i < 5; i++) {
            path[i][i] = i;
        }

        shortpath = shortestpath(m, path);

        // Imprime distancias más cortas.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(shortpath[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("De dónde a dónde usted quiere encontrar el camino más corto?(0 to 4)");
        System.out.println("ingrese cordenada en x");
        int start = stdin.nextInt();
        System.out.println("ingrese cordenada en y");
        int end = stdin.nextInt();

        // La ruta finalizará siempre en fin.
        String myPath = end + "";

        // Recorrer cada vértice anterior hasta que vuelvas a empezar.
        while (path[start][end] != start) {
            myPath = path[start][end] + " -> " + myPath;
            end = path[start][end];
        }

        // Sólo tiene que añadir comienzo de nuestra cadena y de impresión.
        myPath = start + " -> " + myPath;
        System.out.println("Este es el camino " + myPath);
        // TODO code application logic here
    }

}
