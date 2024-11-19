package it.marcoschiavo.porto;

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
	public String addBarca(Barca barca, int index) {
		if((index >= 1 && index <= 20) && barca.getLunghezza() > 10) {
			return "Non è possibile aggiungere questa barca ha una lunghezza maggiore di 10 m";	
		}else if(barca.getTipo() == Barca.Tipologia.VELA) {
			int indice = 0;
			for(int i = 50 ; i < NUMEROPOSTI ; i++) {
				if(this.posti[i] == null) {
					indice = i;
					break;
				}
			}
			if(indice > 0) {
				this.posti[indice-1] = new Posto(barca,indice);
				index = indice;
			}else {
				this.posti[index-1] = new Posto(barca,index);
			}
		}else {
			this.posti[index-1] = new Posto(barca,index);
		}
		return "Barca inserita al posto n° " + index;
	}
	
	
	
	

}
