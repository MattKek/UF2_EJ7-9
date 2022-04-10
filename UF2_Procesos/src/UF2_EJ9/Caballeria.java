package UF2_EJ9;

import java.util.Random;

public class Caballeria {

	private String name;
	private int seconds;
	private static Random ran=new Random();	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public Caballeria(String name) {
		
		this.name = name;
		
		this.seconds=ran.nextInt(8 -1 + 1) + 1;
	
	}
	
	public void startRace() {
		System.out.println("Sale el caballo "+ this.getName());
		try {
			Thread.sleep((long) (this.getSeconds()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Soy el caballo "+ this.getName()+ " he tardado "+this.getSeconds()+ " segundos");
		
	}

}