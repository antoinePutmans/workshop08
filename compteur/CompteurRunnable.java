package compteur;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class CompteurRunnable implements Runnable {

    private String nom;
    private int max;

    //TODO: ajouter un attribut de classe qui retient l'ordre d'arrivée.
    public static AtomicInteger position = new AtomicInteger(1);

    @Override
    public void run() {
        //TODO: 1. Compter jusqu'à max
        //         A chaque incrémentation, afficher le nom du compteur et son compte actuel.
        for(int i = 1; i< max; i++) {
            System.out.println(this.nom + " " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.nom + " 10" );
        System.out.println(this.nom + " a fini de compter et est en position " + position.getAndIncrement());
    }
        //      2. Quand le compte est terminé, afficher que le compteur a finit de compter
        //         et indiquer son ordre d'arrivée.

    public CompteurRunnable(String nom, int max) {
        this.nom = nom;
        this.max = max;
    }


    public String getNom() {
        return nom;
    }

}