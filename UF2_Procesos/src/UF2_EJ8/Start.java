package UF2_EJ8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner read=new Scanner(System.in);
		int numberOfHorses = 3;
		Caballeria [] myHorses=new Caballeria[numberOfHorses];
		
		
		for(int i=0;i<numberOfHorses;i++) {
			System.out.println("Introduzca el nombre del caballo "+(i+1));
			myHorses[i]=new Caballeria(read.next());
		}
    	Thread runningThreads[] = new Thread[numberOfHorses];
		for(int i=0;i<numberOfHorses;i++) {
			Thread t=new Thread(myHorses[i]);
			runningThreads[i]=t;
			t.start();
			
			
		}
		Caballeria winner = Arrays.stream(myHorses)
			      .min(Comparator.comparing(Caballeria::getSecs)).orElseThrow(NoSuchElementException::new);
		
		Caballeria last = Arrays.stream(myHorses)
			      .max(Comparator.comparing(Caballeria::getSecs)).orElseThrow(NoSuchElementException::new);
		float dr = last.getSecs();
		
		int sleep;
		sleep=(int)dr;
		sleep=sleep*1000+500;
		Thread.sleep(sleep);
		   System.out.println("El ganador ha sido "+winner.getNombreCaba());
		  
	}
}

