package it.marcoschiavo.porto;

public class Barca {
	public enum Tipologia{
		VELA,MOTORE;
	}
	
	private String nome;
	private String naz;
	private double lunghezza;
	private double stazza;
	private Tipologia tipo;

	public Barca(String nome,String naz,double lunghezza,double stazza, Tipologia tipo) {
		setNome(nome);
		setNaz(naz);
		setLunghezza(lunghezza);
		setStazza(stazza);
		setTipo(tipo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNaz() {
		return naz;
	}

	public void setNaz(String naz) {
		this.naz = naz;
	}

	public double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public double getStazza() {
		return stazza;
	}

	public void setStazza(double stazza) {
		this.stazza = stazza;
	}

	public Tipologia getTipo() {
		return tipo;
	}

	public void setTipo(Tipologia tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Barca [nome=" + nome + ", naz=" + naz + ", lunghezza=" + lunghezza + ", stazza=" + stazza + ", tipo="
				+ tipo + "]";
	}
	
	
	

}
