package Proiect1_final;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Bursa extends Thread implements Runnable{

    private final Object LOCK = new Object();

    private List<Actiune> oferte = new ArrayList<>();
    private List<Actiune> cereri = new ArrayList<>();
    private Vector listeners = new Vector();
    
    private List<Cumparator> cumparator = new ArrayList<>();

    public void adaugaOferta(Actiune a) {
        synchronized (LOCK) {
        	oferte.add(a);
        }
    }

    public void adaugaCerere(Actiune a) {
        synchronized (LOCK) {
        	cereri.add(a);
        }
    }
    
    public void adaugaCumparator(Cumparator c) {
    	cumparator.add(c);
    }

    public void run() {
        while(true) {
            for(int i=0; i < cereri.size(); i++) {
                Actiune cerere;
                synchronized (LOCK)  {
                	cerere = cereri.get(i);
                }
                for(int j=0; j < oferte.size(); j++) {
                    Actiune oferta;
                    synchronized (LOCK)  {
                    	oferta = oferte.get(j);
                    }
                    
                    for(int k = 0; k < cumparator.size(); k++) {
	                    if(cumparator.get(k).getMinim() < oferta.getPretA() && oferta.getPretA() < cumparator.get(k).getMaxim()) {
	                       
	                    	notificareOferta();
	
	                        synchronized (LOCK) {
	                        	oferte.remove(oferta);
	                        }
	
	                        synchronized (LOCK) {
	                        	cereri.remove(cerere);
	                        }

	                        break;
	                    }
                    }
                }
            }
        }
    }
    
    public void notificareOferta() {
    	
    	String nume = null;
    	int pret = 0;
    	Vector tmpList;
    	Actiune ac=new Actiune(this, nume, pret);
    	synchronized( this ){
    		tmpList = (Vector ) listeners.clone();
    		for( int i=0; i<tmpList.size(); i++){
                ((PretActiuneListener ) tmpList.elementAt(i)).adaugareActiune( ac );
    	}
    }
    	

}
}

