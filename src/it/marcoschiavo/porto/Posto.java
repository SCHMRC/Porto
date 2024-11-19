package it.marcoschiavo.porto;

public class Posto {
	private Barca barca;
	private int numero;
	private double prezzo;

	public Posto() {}
	
	public Posto(Barca barca, double prezzo) {
		this.barca = barca;
		this.prezzo = prezzo;
	}

}
