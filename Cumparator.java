package Proiect1_final;

import java.util.Random;

import java.util.Random;

public class Cumparator extends Thread implements Runnable {


    private String nume;
    private Bursa bursa;
    private int minim, maxim;

    public Cumparator(String nume, Bursa b, int min, int max) {
        this.nume=nume;
        this.bursa = b;
        this.minim = min;
        this.maxim = max;
    }

    public String getNameC() {
        return nume;
    }
    
    public int getMinim() {
    	return minim;
    }
    
    public int getMaxim() {
    	return maxim;
    }

    public void run() {
        Random random = new Random();
        System.out.println("Cumparatorul " + getNameC() + " incepe tranzactionarea!");
        
        bursa.adaugaCumparator(this);
        
        while(true) {
            int pret = 1 + random.nextInt(10);
            Actiune a = new Actiune(this, nume, pret);
            bursa.adaugaCerere(a);
        }
    }
}
