/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author wilmer
 */
public class Archivo {

    public void escribir(String nombreArchivo, String Datos) {

        File f;
        FileWriter w;
//Escritura
        try {
            f = new File("C:\\nombreArchivo.txt");
            w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("wilmer");//escribimos en el archivo
            wr.append(" - y aqui continua"); //concatenamos en el archivo sin borrar lo existente
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();

            bw.close();

        } catch (IOException e) {
        };

    }

    public PrintWriter crearArchivo() {
        //Las siguientes 3 líneas nos permite crear un archivo y escribir en el
        PrintWriter salida = null;
        try {
            File archivo = new File("C:\\rchivo.txt");
            FileWriter writer = new FileWriter(archivo);
            salida = new PrintWriter(writer);
        } catch (Exception e) {
        }

        return salida;
    }

    public PrintWriter escribirArchivo(PrintWriter salida, String cadena) {
        try {
            //Este método permite escribir en el archivo
            salida.append("Mi Archivo Plano");
            //Este método sirve para dar un salto de línea
            salida.println();
            //Tambien el método write nos permite escribir
            salida.write(cadena);
            //Al Igual que print
            //  salida.print(new String(cadena));
            //Es importante no olvidar cerrar el archivo
            salida.close();
        } catch (Exception e) {
        }

        return salida;
    }

    public String leerArchivo(String ruta) {
        String contenido = "";
        try {
            //Se crea un objeto File usando el constructor que recibe la ruta(String)
            File archivo = new File(ruta);
            //Usamos estos 2 objetos porque BufferedReader contiene un método sencilo
            //Para leer el archivo por linea
            FileReader fileReader = new FileReader(archivo);
            BufferedReader buffReader = new BufferedReader(fileReader);
            //Aquí guardaremos cada línea del archivo por vez
            String linea = null;
            //Aquí acumularemos todas las líneas

            //Cada que se invoca el método readLine() se busca una linea y el cursor
            //pasa a la siguiente linea cuando no hay mas lineas regresa null
            System.out.println("Cargando");
            while ((linea = buffReader.readLine()) != null) {
                //System.out.println(linea);
                contenido += " " + linea;
            }
            //Se valida que no sea nulo y se cierra 
            if (null != fileReader) {
                fileReader.close();
            }

        } catch (Exception e) {
        }
        return contenido;
    }

}
