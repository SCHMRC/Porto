package it.marcoschiavo.porto;

public class Start {

	public static void main(String args[]) {
		Porto porto = new Porto("Ligure","asdfggg");
		
		Barca barca1 = new Barca("Jenny","America",5,100,Barca.Tipologia.MOTORE);
		Barca barca2 = new Barca("Prada","Italia",80,50,Barca.Tipologia.VELA);
		
		System.out.println(porto.addBarca(barca1,12));
		
		for(int i = 0; i < 100 ; i++) {
			System.out.println(porto.getPosti()[i]);
		}
		
		
	}

}
