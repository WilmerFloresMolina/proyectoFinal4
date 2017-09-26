package projecto_final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author wilmer
 */
public class Projecto_Final {

    public static void main(String[] args) {

        Archivo ar = new Archivo();
//        
        /*  String saludo = "";

        try {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("texto.txt");

//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

//Escribimos en el archivo con el metodo write 
            escribir.write(saludo);

//Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }*/

        //ar.escribirArchivo(salida, cadena)
        Grafo nuevo = new Grafo();
        Grafo nuevo2 = new Grafo();
        //Grafo nuevo3 = new Grafo();
        int contador = 0;

        int id = nuevo.getNodos().size();
        Node2 temp7 = new Node2("1");

        // System.out.println(opcion + "-" + id);
        // nuevo.addVertex(temp7);
        Node2 temp2 = new Node2("2");
        //  nuevo.addVertex(temp2);
        Node2 temp3 = new Node2("3");
        Node2 temp4 = new Node2("4");
        Node2 temp5 = new Node2("5");
        Node2 temp6 = new Node2("6");

        /* nuevo.addVertex(temp3);
        nuevo.addVertex(temp4);
        nuevo.addVertex(temp5);
        nuevo.addVertex(temp6);*/
        nuevo2.addVertex(temp7);
        nuevo2.addVertex(temp2);
        nuevo2.addVertex(temp3);
        nuevo2.addVertex(temp4);

        //nuevo.addEdge(temp3, "");
        /*  Arista arista20 = new Arista(12, nuevo.getNodos().elementAt(0), nuevo.getNodos().elementAt(3));
        Arista arista2 = new Arista(15, nuevo.getNodos().elementAt(1), nuevo.getNodos().elementAt(2));
        Arista arista3 = new Arista(5, nuevo.getNodos().elementAt(2), nuevo.getNodos().elementAt(3));
        Arista arista4 = new Arista(7, nuevo.getNodos().elementAt(3), nuevo.getNodos().elementAt(4));
        Arista arista5 = new Arista(8, nuevo.getNodos().elementAt(3), nuevo.getNodos().elementAt(5));*/
        Arista arista6 = new Arista(0, nuevo2.getNodos().elementAt(0), nuevo2.getNodos().elementAt(1));
        Arista arista7 = new Arista(0, nuevo2.getNodos().elementAt(1), nuevo2.getNodos().elementAt(2));
        Arista arista8 = new Arista(0, nuevo2.getNodos().elementAt(2), nuevo2.getNodos().elementAt(3));
        // Arista arista9 = new Arista(0, nuevo2.getNodos().elementAt(3), nuevo2.getNodos().elementAt(0));
        // Arista arista10 = new Arista(8, nuevo2.getNodos().elementAt(3), nuevo2.getNodos().elementAt(5));

        /*nuevo.addEdge(nuevo.getNodos().elementAt(0), arista2);
        nuevo.addEdge(nuevo.getNodos().elementAt(1), arista3);
        nuevo.addEdge(nuevo.getNodos().elementAt(2), arista20);
        nuevo.addEdge(nuevo.getNodos().elementAt(3), arista4);
        nuevo.addEdge(nuevo.getNodos().elementAt(4), arista5);*/
        //
        nuevo2.addEdge(nuevo2.getNodos().elementAt(0), arista6);
        nuevo2.addEdge(nuevo2.getNodos().elementAt(1), arista7);
        nuevo2.addEdge(nuevo2.getNodos().elementAt(2), arista8);
        //W nuevo2.addEdge(nuevo2.getNodos().elementAt(3), arista9);
        /* for (int i = 0; i < nuevo.getNodos().size(); i++) {
            System.out.println(nuevo.getVertex(i));
        }*/
        //System.out.println(nuevo.generarAdyacencia());
        //  double[][] matriz = nuevo.generarAdyacencia();
        /*for (int i = 0; i < matriz.length; i++) {
            System.out.println("");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.format("[" + matriz[i][j] + "]");

            }
        }
        System.out.println("");*/
        //nuevo.getNodos().elementAt(nuevo.getNodos().size() - 1).setID(id);
        /* for (int i = 0; i < nuevo.getNodos().size(); i++) {
            nuevo.getVertex(i).getAristas();
        }*/
        // nuevo.getVertex(0).getAristas();
        /*nuevo2.pintar();
        nuevo2.getaristas();
        System.out.println(nuevo.getNodos().size());
        System.out.println("Eficiencia: " + nuevo.getadjacentVertices2(nuevo.getNodos().elementAt(0)));

        for (int i = 0; i < nuevo.getNodos().size(); i++) {
            System.out.println(nuevo.getNodos().elementAt(i).getValue());
        }
        nuevo2.bicoloreable();*/

        String numeros = ar.leerArchivo("Árbol evaluación.txt");
        String[] numerosComoArray = numeros.split(",");
        /*for (int i = 0; i < numerosComoArray.length; i++) {
            System.out.print(","+numerosComoArray[i]);
        }*/
        String matriz[][] = new String[13][3];
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = numerosComoArray[cont];
                cont++;
            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 3; j++) {
                //System.out.print("[" + matriz[i][j] + "]");
            }
            // System.out.println("");
        }
        for (int i = 0; i < matriz.length; i++) {
            Node2 temp10 = new Node2(matriz[i][0]);
            nuevo.addVertex(temp10);
        }
        int findi = 0;
        int findj = 0;

        for (int i = 0; i < matriz.length; i++) {

            Arista arista23 = new Arista(Integer.parseInt(matriz[i][2]), nuevo.getNodos().elementAt(i), nuevo.getNodos().elementAt(Integer.parseInt(matriz[i][1]) - 1));
            nuevo.addEdge(nuevo.getNodos().elementAt(i), arista23);

        }
        /* for (int i = 0; i < matriz.length; i++) {

        }*/

        try {
            int opcion = 0;
            while (opcion < 11) {
                Scanner read = new Scanner(System.in);
                System.out.println("\033[35m* " + "\033[35m*********** " + "\033[30mMENU" + " \033[35m***********" + " \033[35m*");
                System.out.println("\033[35m* " + "\033[31m1-" + "\033[34m Arbol de eficiencia" + "       \033[35m*");
                System.out.println("\033[35m* " + "\033[31m2-" + "\033[34m Expresiones matematicas" + "   \033[35m*");
                System.out.println("\033[35m* " + "\033[31m3-" + "\033[34m Hoffman" + "                   \033[35m*");
                System.out.println("\033[35m* " + "\033[31m4-" + "\033[34m Bicoloreable" + "              \033[35m*");
                System.out.println("\033[35m* " + "\033[31m5-" + "\033[34m Floyd" + "                     \033[35m*");
                System.out.println("\033[35m* " + "\033[31m6-" + "\033[34m Dijkstra" + "                  \033[35m*");
                System.out.println("\033[35m* " + "\033[31m7-" + "\033[34m Kruskal" + "                   \033[35m*");
                System.out.println("\033[35m* " + "\033[31m8-" + "\033[34m Floyd" + "                     \033[35m*");
                System.out.println("\033[35m* " + "\033[31m9-" + "\033[34m Prim" + "                       \033[35m*");
                System.out.println("\033[35m* " + "\033[31m10-" + "\033[34m Manual" + "                    \033[35m*");
                System.out.println("\033[35m* " + "\033[31m11-" + "\033[34m Salir" + "                     \033[35m*");
                System.out.println("\033[35m* **************************** *");
                System.out.print("Ingrese opcion: ");
                try {
                    opcion = read.nextInt();
                } catch (Exception e) {

                }

                if (opcion == 1) {
                    System.out.println("\033[31m*********** Arbol De Eficiencia ***********");
                    String nombre = "";
                    String respuesta = "";
                    int posicion1, posicionFinal;
                    double tamano;
                    do {
                        for (int i = 0; i < nuevo.getNodos().size(); i++) {
                            System.out.println(i + ") " + nuevo.getNodos().elementAt(i).toString() + ",");
                        }
                        System.out.println("-------------------------------------------");
                        System.out.print("Ingrese nombre del nodo: ");
                        nombre = read.next();

                        Node2 temp = new Node2(nombre);
                        nuevo.addVertex(temp);
                        System.out.print("Desea ingresar nuevo nodo? s/n: ");
                        respuesta = read.next().toLowerCase();
                    } while (respuesta.equals("s"));
                    respuesta = "s";
                    do {
                        System.out.print("Ingrese la posicion del nodo inicial: ");
                        posicion1 = read.nextInt();
                        System.out.print("Ingrese la posicion del nodo final: ");
                        posicionFinal = read.nextInt();
                        System.out.print("Ingrese tamaño de la Arista: ");
                        tamano = read.nextDouble();

                        Arista arista = new Arista(tamano, nuevo.getNodos().elementAt(posicion1), nuevo.getNodos().elementAt(posicionFinal));

                        nuevo.addEdge(nuevo.getNodos().elementAt(contador), arista);
                        contador++;
                        System.out.print("Desea ingresar nueva arista? s/n: ");
                        respuesta = read.next().toLowerCase();
                    } while (respuesta.equals("s"));

                    nuevo.getaristas();
                    System.out.println("\033[30mNota: " + "\033[34m" + nuevo.getadjacentVertices2(nuevo.getNodos().elementAt(0)) / nuevo.getNodos().size() + "\n");

                } // fin opcion1

                if (opcion == 2) {
                    System.out.println("\033[31m*********** Expresiones Matematicas ***********");
                    System.out.println("\n\033[30mIngrese una operacion: " + "\033[34m");
                    String op = read.next();
                    Calc cal = new Calc();
                    try {
                        Expresion e = new Expresion(op);
                        System.out.println("\033[32mResultado= " + "\033[34m" + cal.calcular(op));
                        System.out.println("");
                        //System.out.println(e.Completo()+" Notación prefija.");
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                } // fin opcion2

                if (opcion == 3) {

                    System.out.println("\033[31m************ Hoffman ************");
                    String frase1 = "";
                    int freq[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
                        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
                        55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79};
                    //  System.out.println(freq.length);
                    char code[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '\n',
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                        '(', ')', '-', '_', 'ü', 'é', 'á', 'í', 'ó', 'ú', 'ñ', 'Ñ', '¿', '?', 'É', 'Í', 'Ó', 'Ú', 'Ü', 'à', '*', ',', '\'', '\\', '\"',};
                    // System.out.println(code.length);
                    HuffTree hTree = new HuffTree(freq, code);
                    System.out.println("");
                    //System.out.println("Encode 'wilmer': " + hTree.encode("wilmer") + "\n");
                    //System.out.println("01011111100111010110111111111110: " + hTree.Decode("01011111100111010110111111111110"));
                    read = new Scanner(System.in);
                    System.out.print("\033[30mIngrese como se llama el archivo: " + "\033[34m");
                    frase1 = read.nextLine();
                    String dato = ar.leerArchivo("C:\\" + frase1);
                    // System.out.println("\033[34m" + frase + "\033[30m a binario: " + "\033[34m" + hTree.encode(frase));
                    // System.out.print("Ingrese Binario: ");
                    // String frase2 = read.next();
                    String dat = "";
                    dat = dat + hTree.encode(dato);

                    try {
                        File archivo = new File("Comprimido.txt");
                        FileWriter escribir = new FileWriter(archivo, true);
                        escribir.write(dat);
                        escribir.close();
                    } catch (Exception e) {
                        System.out.println("Error al escribir");
                    }
                    //  System.out.println("\033[30mDe binario: " + "\033[34m" + "\033[30m a frase: " + "\033[34m");
                    System.out.println("");
                    String Bits = "";
                    Bits = Bits + ar.leerArchivo("Comprimido.txt");
                    // System.out.println(Bits);
                    System.out.println("Ingrese codigo binario: ");

                    read = new Scanner(System.in);
                    String Bitsw = read.nextLine();
                    String datosN = hTree.decode(Bitsw);
                    try {
                        File archivo = new File("Descomprimido.txt");
                        FileWriter escribir = new FileWriter(archivo, true);
                        escribir.write(datosN);
                        escribir.close();
                    } catch (Exception e) {
                        System.out.println("Error al escribir");
                    }
                } // fin opcion3

                if (opcion == 4) {
                    String respuesta = "s";
                    String nombre = "";
                    do {
                        System.out.println("\033[31m*********** Bicoloreable ***********");
                        nuevo2.pintar();
                        nuevo2.getaristas();
                        nuevo2.bicoloreable();
                        for (int i = 0; i < nuevo2.getNodos().size(); i++) {
                            System.out.println(i + ") " + nuevo.getNodos().elementAt(i).toString() + ",");
                        }
                        System.out.println("-------------------------------------------");
                        System.out.print("Ingrese nombre del nodo: ");
                        nombre = read.next();

                        Node2 temp = new Node2(nombre);
                        nuevo2.addVertex(temp);
                        System.out.print("Desea ingresar nuevo nodo? s/n: ");
                        System.out.println("");
                        respuesta = read.next().toLowerCase();
                    } while (respuesta.equals("s"));
                    do {
                        System.out.print("Ingrese la posicion del nodo inicial: ");
                        int posicion1 = read.nextInt();
                        System.out.print("Ingrese la posicion del nodo final: ");
                        int posicionFinal = read.nextInt();

                        Arista arista = new Arista(0, nuevo.getNodos().elementAt(posicion1), nuevo.getNodos().elementAt(posicionFinal));

                        nuevo2.addEdge(nuevo.getNodos().elementAt(contador), arista);
                        contador++;
                        System.out.print("Desea ingresar nueva arista? s/n: ");
                        respuesta = read.next().toLowerCase();
                    } while (respuesta.equals("s"));
                } // fin opcion4

                if (opcion == 5) {
                    System.out.println("\033[31m************ Floyd ************");
                    int[][] matrizA = nuevo.Floyd();
                    System.out.println("");
                    //System.out.println("----------Floyd------------");
                    for (int i = 0; i < matrizA.length; i++) {
                        for (int j = 0; j < matrizA[i].length; j++) {
                            System.out.print("[" + matrizA[i][j] + "]");
                        }
                        System.out.println("");
                    }

                    System.out.println("");
                } // fin opcion5

                if (opcion == 6) {
                    System.out.println("\033[31m************ Dijkstra ************");
                    System.out.println("Ejemplo");
                    System.out.println("5 9\n"
                            + "1 2 7\n"
                            + "1 4 2\n"
                            + "2 3 1\n"
                            + "2 4 2\n"
                            + "3 5 4\n"
                            + "4 2 3\n"
                            + "4 3 8\n"
                            + "4 5 5\n"
                            + "5 3 5\n"
                            + "1\n"
                            + "5");
                    Dijkstra d = new Dijkstra();
                    d.dij();

                } // fin opcion6

                if (opcion == 7) {
                    System.out.println("\033[31m************ Kruskal ************");
                    System.out.println("Ejemplo");
                    System.out.println("9 14\n"
                            + "1 2 4\n"
                            + "1 8 9\n"
                            + "2 3 9\n"
                            + "2 8 11\n"
                            + "3 4 7\n"
                            + "3 9 2\n"
                            + "3 6 4\n"
                            + "4 5 10\n"
                            + "4 6 15\n"
                            + "5 6 11\n"
                            + "6 7 2\n"
                            + "7 8 1\n"
                            + "7 9 6\n"
                            + "8 9 7");

                    Kruskal k = new Kruskal();
                    k.krus();
                }
                if (opcion == 8) {
                    Floyd fl = new Floyd();
                    fl.main();
                }
                if (opcion == 9) {
                    Prim p = new Prim();
                    p.main();
                }
                if (opcion == 10) {
                    System.out.println("\033[31m************ Manual ************");
                    System.out.println("El proyecto tiene arboles y grafos uno escoge que metodo va usar a medida \n"
                            + "si uno escoge un huffman igresa una palabra y la convierte a binario si es un arbol\n"
                            + "el prgrama le pedira qu ingrese nodos y tambien que conecte los nodos con sus aristas y\n "
                            + "su tamaño"
                            + "");

                }

            } // fin while
        } catch (Exception e) {

            System.out.println("Uoop! Error!");

        } // fin try catch

    } // fin main

} // fin class
