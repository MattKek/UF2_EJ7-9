package UF2_EJ9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

import UF2_EJ8.Caballeria;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner read=new Scanner(System.in);
		int numberOfHorses = 3;
		String select;
		Caballeria [] myHorses=new Caballeria[numberOfHorses];
		
		
		for(int i=0;i<numberOfHorses;i++) {
			System.out.println("Introduzca el nombre del caballo "+(i+1));
			myHorses[i]=new Caballeria(read.next());
		}
		
		System.out.println("Cuanto desea apostar?");
		float sum = read.nextFloat();
		System.out.println("A que caballo desea apostar? (Nombre)");
		select = read.next();
				
		Caballeria winner = Arrays.stream(myHorses)
			      .min(Comparator.comparing(Caballeria::getSecs)).orElseThrow(NoSuchElementException::new);
		String ganador = winner.getNombreCaba();
		  
		
		Caballeria last = Arrays.stream(myHorses)
			      .max(Comparator.comparing(Caballeria::getSecs)).orElseThrow(NoSuchElementException::new);
		float dr = last.getSecs();
		
		int sleep;
		sleep=(int)dr;
		sleep=sleep*1000+500;
		
    	Thread runningThreads[] = new Thread[numberOfHorses];
    	
		for(int i=0;i<numberOfHorses;i++) {
			Thread t=new Thread(myHorses[i]);
			runningThreads[i]=t;
			t.start();
		}

		
		Thread.sleep(sleep);
		System.out.println("\n===================================================================================");
		System.out.println("\nEl caballo ganador es: "+ganador+"\n");
		if(select.equals(ganador)) {
			sum = sum*3;
			System.out.println("Enhorabuena has ganado un total de: "+sum+"€ por apostar al caballo "+ganador);
			System.out.println("\n===================================================================================");
		} else {
			System.out.println("Mala suerte, el caballo ganador ha sido: "+ganador+ "\nHas perdido "+sum+"€\nSuerte la proxima vez!");
			System.out.println("\n===================================================================================");
		}
	}
}

		