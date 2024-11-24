package it.marcoschiavo.porto;

import it.marcoschiavo.porto.Barca.Tipologia;

public class Porto {
	private final int NUMEROPOSTI = 100;
	private Posto posti[];
	private String denominazione;
	private String piva ;

	public Porto(String denominazione, String piva) {
		this.denominazione = denominazione;
		this.piva = piva;
		this.posti = new Posto[NUMEROPOSTI];
	}
	
	
	public Posto[] getPosti() {
		return posti;
	}


	public void setPosti(Posto[] posti) {
		this.posti = posti;
	}


	public String getDenominazione() {
		return denominazione;
	}


	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}


	public String getPiva() {
		return piva;
	}


	public void setPiva(String piva) {
		this.piva = piva;
	}


	//i posti da 1 a 20 non possono ospitare barche più lunghe di 10 m 
	//barche a vela devono essere piazzate in via prioritaria nei posti successivi al 50
	public String[] addBarca(Barca barca, int index) {
		String[] stringa = new String[2];
		stringa[0] = "0";
		if((index >= 1 && index <= 20) && barca.getLunghezza() > 10) {
			stringa[1] = "\nNon è possibile aggiungere questa barca ha una lunghezza maggiore di 10 m \npuoi sceglire un posto il cui numero è maggiore di 20\n";
			return stringa;	
		}else if(barca.getTipo() == Barca.Tipologia.VELA) {
			int indice = 0;
			for(int i = 51 ; i < NUMEROPOSTI ; i++) {
				if(this.posti[i] == null) {
					indice = i;
					break;
				}
			}
			if(indice > 0) {
				this.posti[indice] = new Posto(barca);
				index = indice;
			}else {
				this.posti[index-1] = new Posto(barca);
			}
		}else {
			if(this.posti[index-1] == null) {
				this.posti[index-1] = new Posto(barca);	
			}else {
				for(int i = index ; i < NUMEROPOSTI ; i++) {
					if(posti[i] == null) {
						this.posti[i] = new Posto(barca);
						index = i+1;
						break;
					}
				}
			}
			
		}
		stringa[0] = "1";
		stringa[1] = "Barca inserita al posto n° " + index + "\n \n";
		return stringa;
	}
	
	//elimina una barca dal porto
	public String delBarca(String nomeBarca, int numeroGiorniSosta) {
		String stringa = "";
		int indice = -1;
		indice = searchBarca(nomeBarca);
		if(indice >= 0 ) {
			double spesa = posti[indice].getSpesa(numeroGiorniSosta);
			Barca barca = posti[indice].getBarca();
			posti[indice] = null;
			stringa = "La Barca "+ barca.getNome() + " è stata eliminata; Totale da pagare: " + spesa;
		}else {
			stringa = "Barca assente";
		}
		return stringa;
	}
	
	// metodo di utilità interno della classe
	// cerca all'interno dell'array un oggetto barca il cui nome è uguale
	// a quello passato come parametro
	// mi restituisce -1 se non trova la barca altrimenti mi restituisce
	// la posizione della barca nell'array
	private int searchBarca(String nomeBarca) {
		int index = -1;
		for(int i = 0 ; i < NUMEROPOSTI ;  i++) {
			if(posti[i] != null && posti[i].getBarca().getNome().equalsIgnoreCase(nomeBarca)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public String getInfoBarca(int index) {
		if(index > 0 && index <= NUMEROPOSTI) {
			if(this.posti[index - 1] != null) {
				return this.posti[index - 1].getBarca().toString();
			}else {
				return "Il posto è vuoto";
			}
			
		}else {
			return "Il numero deve essere compreso tra 1 e 100";
		}

	}
	
	public String[] getNomiBarche(String naz) {
		String[] lista = new String[numeroBarchePresenti(naz)];
		int k = 0;
		for(int i = 0 ; i < NUMEROPOSTI ;  i++) {
			if(posti[i] != null && posti[i].getBarca().getNaz().equalsIgnoreCase(naz) ) {
				lista[k] = posti[i].getBarca().getNome();
				k++;
			}
		}
		return lista;
	}
	
	private int numeroBarchePresenti(String naz) {
		int numeroBarche = 0;
		for(int i = 0 ; i < NUMEROPOSTI ;  i++) {
			if(posti[i] != null && posti[i].getBarca().getNaz().equalsIgnoreCase(naz)) {
				numeroBarche++;
			}
		}
		return numeroBarche;
	}
	
	
	

}
