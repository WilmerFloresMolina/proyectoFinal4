
package projecto_final;

import java.util.LinkedList;

public class Calc {

    public Calc() {
    }

    public double calcular(String Expre) throws Exception {
        double resultado = 0;
        String aux = Expre;
        Comprobador scanner = new Comprobador();
        aux = scanner.Scan(aux);
        if (aux.equals("P") || aux.equals("O")) {
            if (aux.equals("P")) {
                throw new Exception("Verificar los paréntesis. Gracias.");
            } else {
                throw new Exception("El número de operadores no es correcto. Gracias.");
            }
        } else {

            Expresion e;
            e = new Expresion(aux);
            LinkedList exp = e.CompletoPrefija();
            if ((exp.size() != 0) && (exp.size() != 2)) {
                ArbolExpresion ar = new ArbolExpresion(exp);
                resultado = ar.Evaluar();
            } else {
                throw new Exception("Verifique la expresión. Gracias.");
            }
        }
        return resultado;
    }
}
