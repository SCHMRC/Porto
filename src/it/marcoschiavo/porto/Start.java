package it.marcoschiavo.porto;

import java.io.InputStreamReader;

import it.marcoschiavo.porto.Barca.Tipologia;
import it.marcoschiavo.porto.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;

public class Start {

	public static void main(String args[]) throws IOException{
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(stream);
		Porto porto = new Porto("Ligure","GLIBRB78E43585LR");
		int option = 0;
		do {
			System.out.println("*********** GESTIONALE PORTO ***********");
			System.out.println("* seleziona 1 per aggiungere una barca *");
			System.out.println("* seleziona 2 per rimuovere  una barca *");
			System.out.println("* seleziona 3 per informazioni   barca *");
			System.out.println("* seleziona 4 per elenco barche per naz*");
			System.out.println("* seleziona qualsiasi numero per uscire*");
			System.out.println("****************************************");
			System.out.print("Inserisci un numero: ");
			option = Integer.parseInt(tastiera.readLine());
			Menu menu = new Menu();
			switch(option) {
			case 1:{
				menu.showStageOne(porto, tastiera);
				break;
			}
			case 2:{
				menu.showStageTwo(porto, tastiera);
				break;
			}
			case 3:{
				menu.showStageThree(porto, tastiera);
				break;
			}
			case 4:{
				menu.showStageFour(porto,tastiera);
				break;
			}
			}
		}while(option > 0 && option < 5);
		
//		System.out.println();
//		
//		
//		
//		Porto porto = new Porto("Ligure","asdfggg");
//		
//		
//		Barca barca0 = new Barca("Jenny0","America",5,100,Barca.Tipologia.MOTORE);
//		Barca barca1 = new Barca("Jenny1","America",5,100,Barca.Tipologia.MOTORE);
//		Barca barca2 = new Barca("Jenny2","America",5,100,Barca.Tipologia.MOTORE);
//		Barca barca3 = new Barca("Jenny3","America",5,100,Barca.Tipologia.MOTORE);
//		Barca barca4 = new Barca("Prada","Italia",80,50,Barca.Tipologia.VELA);
//		
//		System.out.println(porto.addBarca(barca0,12));
//		System.out.println(porto.addBarca(barca1,12));
//		System.out.println(porto.addBarca(barca2,12));
//		System.out.println(porto.addBarca(barca3,12));
//		System.out.println(porto.addBarca(barca4,25));
//		
//		for(int i = 0 ; i < porto.getNomiBarche("Italia").length ; i++) {
//			System.out.println(porto.getNomiBarche("Italia")[i]);	
//		}
		
	}
				
		
		

}
