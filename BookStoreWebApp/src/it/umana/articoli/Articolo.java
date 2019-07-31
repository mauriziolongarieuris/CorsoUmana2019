package it.umana.articoli;

import java.io.Serializable;

public abstract class Articolo implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 6448472936720116825L;
	
	
	private String codice;
	
	public Articolo () {
		
	}
	
	public Articolo (String codice) {
		this.codice = codice;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	@Override
    public Object clone () throws CloneNotSupportedException {
		Articolo articolo = (Articolo)super.clone();
		articolo.setCodice( new String(getCodice()) );
    	return articolo;
    }
	
}
