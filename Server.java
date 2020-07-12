package Proiect1_final;

public class Server {

    public static void main(String[] args) {
        Bursa b = new Bursa();

        Cumparator c1=new Cumparator("Cumparator Petrica", b, 2, 8);
        Cumparator c2=new Cumparator("Cumparator Gigel", b, 3, 7);
        Cumparator c3=new Cumparator("Cumparator Ionel", b, 4, 6);

        Vanzator v1=new Vanzator("Vanzator Maria",b);
        Vanzator v2=new Vanzator("Vanzator Veorica",b);
        Vanzator v3=new Vanzator("Vanzator Gica",b);

        c1.start();
        c2.start();
        c3.start();

        v1.start();
        v2.start();
        v3.start();

        b.start();
    }

}
