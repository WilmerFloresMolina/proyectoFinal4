
package projecto_final;

import projecto_final.operador;

public class Nodo {

    private Nodo HI;
    private operador Data;
    private Nodo HD;

    public Nodo() {
        Data = new operador();
        HI = null;
        HD = null;
    }

    public Nodo(operador dat) {
        this.Data = dat;
        this.HI = null;
        this.HD = null;
    }

    public Nodo(Nodo Hisq, operador dat, Nodo Hder) {
        this.Data.setValor(dat.getValor());
        this.Data.setOperador(dat.getOperator());
        this.HI = Hisq;
        this.HD = Hder;
    }

    public void setData(operador dat) {
        this.Data.setValor(dat.getValor());
        this.Data.setOperador(dat.getOperator());
    }

    public void setHI(Nodo Hisq) {
        this.HI = Hisq;
    }

    public void setHD(Nodo Hder) {
        this.HD = Hder;
    }

    public operador getData() {
        return this.Data;
    }

    public Nodo getHI() {
        return this.HI;
    }

    public Nodo getHD() {
        return this.HD;
    }

}
