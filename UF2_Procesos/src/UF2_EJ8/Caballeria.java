package UF2_EJ8;

import java.util.Arrays;
import java.util.Random;

public class Caballeria implements Runnable {
	
    private String nombreCaba;
    private float secs;
    private static Random rand=new Random();
    
    public String getNombreCaba() {
    return nombreCaba;
    }
    
    public void setNombreCaba(String nombreCaba) {
    this.nombreCaba = nombreCaba;	
    	}
    
    public float getSecs() {
    return secs;
    }
    
    public void setSecs(float secs) {
    this.secs = secs;
    }
    
    public Caballeria(String nombreCaba) {
    
    this.nombreCaba = nombreCaba;
    
    this.secs = rand.nextInt(8 -1 + 1) + 1;
    }
    
    public void run() {
    	System.out.println("Sale "+this.getNombreCaba());
    	try {
    		Thread.sleep((long) (this.getSecs()*1000));
    	} catch (InterruptedException exc) {
    		System.out.println(this.getNombreCaba()+ "Interrumpido.");
    	}

    	
        System.out.println("Soy el caballo "+this.getNombreCaba()+" he tardado "+this.getSecs()+" segundos");
    }
}
