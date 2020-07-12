package Proiect1_final;

import java.util.EventObject;

public class Actiune  extends EventObject{

    private String nume;
    private int pret;


    public Actiune(Object source, String nume, int pret) {
        super(source);
    	this.nume=nume;
        this.pret=pret;
    }

    public String getNameA() {
        return nume;
    }

    public int getPretA() {
        return pret;
    }
}
