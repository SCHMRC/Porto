package it.marcoschiavo.porto;

import it.marcoschiavo.porto.Barca.Tipologia;

public class Posto {
	private Barca barca;
	private int numero;
	private double prezzo;

	public Posto() {}
	
	public Posto(Barca barca) {
		this.barca = barca;
		setPrezzoPostoBarca(barca);
	}
	
	public Barca getBarca(){
		return this.barca;
	}
	
	public double getPrezzo() {
		return this.prezzo;
	}
	
	private void setPrezzoPostoBarca(Barca b) {
		if(b.getTipo() == Tipologia.MOTORE) {
			this.prezzo = 20;
		}else {
			this.prezzo = 10;
		}
	}
	
	public double getSpesa(int numeroGiorni) {
		double prezzo = 0;
		if(barca.getTipo() == Tipologia.MOTORE) {
			prezzo = (this.prezzo * barca.getStazza()) * numeroGiorni;
		}else {
			prezzo = (this.prezzo * barca.getLunghezza()) * numeroGiorni;
		}
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.barca.getNome() + "; naz: " + this.barca.getNaz();
	}

}
