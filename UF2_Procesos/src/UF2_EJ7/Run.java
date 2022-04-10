package UF2_EJ7;

import java.util.Scanner;

public class Run {
	
    public static void main(String[] args) {
    	Scanner read = new Scanner(System.in);
    	
    	int numberOfHorses = 3;
    	Caballeria [] myHorses=new Caballeria[numberOfHorses];

    	
    	for(int i=0;i<numberOfHorses;i++) {
			System.out.println("Dame el nombre del caballo "+(i+1)+".");
			myHorses[i]=new Caballeria(read.next());
		}
    	       
    	Thread runningThreads[] = new Thread[numberOfHorses];
		for(int i=0;i<numberOfHorses;i++) {
			Thread t=new Thread(myHorses[i]);
			runningThreads[i]=t;
			t.start();
		}
      
    }
    
}