package it.marcoschiavo.porto.menu;

import it.marcoschiavo.porto.Barca;
import it.marcoschiavo.porto.Barca.Tipologia;
import it.marcoschiavo.porto.Porto;

import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
	
	public Menu() {}
	
	public void showStageOne(Porto porto, BufferedReader tastiera) throws IOException {
		System.out.println("Inserisci le info sulla barca:");
		System.out.print("Nome: ");
		String nome = tastiera.readLine();
		System.out.print("Nazionalità: ");
		String naz = tastiera.readLine();
		System.out.print("Lunghezza: ");
		double lun = Double.parseDouble(tastiera.readLine());
		System.out.print("Stazza: ");
		double stazza = Double.parseDouble(tastiera.readLine());
		System.out.println("Tipologia: ");
		System.out.println("scegli 1 per barca a MOTORE");
		System.out.println("scegli 2 per barca a VELA");
		int tipo = Integer.parseInt(tastiera.readLine());
		Tipologia tipologia = Tipologia.MOTORE;
		if(tipo > 1) {
			tipologia = Tipologia.VELA;
		}
		Barca barca = new Barca(nome,naz,lun,stazza,tipologia);
		boolean flag;
		do {
			flag = false;
			System.out.print("Inserisci la posizione della barca nel porto: ");
			int posizione = Integer.parseInt(tastiera.readLine());
			String[] result = porto.addBarca(barca,posizione);
			System.out.println(result[1]);
			if(Integer.parseInt(result[0]) == 0) {
				flag = true;
			}
		}while(flag);
	}

	public void showStageTwo(Porto porto, BufferedReader tastiera) throws IOException {
		System.out.print("Inserisci il nome della barca: ");
		String nomeBarca = tastiera.readLine();
		System.out.print("Giorni di permanenza: ");
		int giorni = Integer.parseInt(tastiera.readLine());
		System.out.println(porto.delBarca(nomeBarca, giorni));
	}

	public void showStageThree(Porto porto, BufferedReader tastiera) throws IOException {
		System.out.print("Inserisci il posto nel porto: ");
		System.out.println(porto.getInfoBarca(Integer.parseInt(tastiera.readLine())));
	}
	
	public void showStageFour(Porto porto, BufferedReader tastiera) throws IOException {
		System.out.print("Inserisci la nazionalità da cercare: ");
		for(String nome : porto.getNomiBarche(tastiera.readLine())) {
			System.out.println(nome);
		}
		
	}


}
