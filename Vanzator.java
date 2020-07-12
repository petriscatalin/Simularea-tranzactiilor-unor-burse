package Proiect1_final;

import java.util.Random;

public class Vanzator extends Thread implements Runnable {

    private String nume;
    private Bursa bursa;

    public Vanzator(String nume, Bursa b) {
        this.nume=nume;
        this.bursa=b;
    }

    public String getNameV() {
        return nume;
    }

    public void run() {
        System.out.println("Vanzatorul " + getNameV() + " incepe tranzactionarea!");
        Random random = new Random();
        while(true) {
            int pret = 1 + random.nextInt(10);
            Actiune a = new Actiune(this, nume, pret);
            bursa.adaugaOferta(a);
        }
    }
}

