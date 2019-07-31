package it.umana.noleggi;

import java.io.Serializable;

public class Noleggio<T> implements Serializable{

	private static final long serialVersionUID = 7595858033615636661L;
	
	
	private Utente utente;
    private T articolo;
    
    public Noleggio(Utente utente,T articolo){
        this.utente=utente;
        this.articolo=articolo;
    }
    
    public void setUtente(Utente utente){
        this.utente=utente;
    }
    
    public Utente getUtente(){
        return utente;
    }
    
    public void setArticolo(T articolo){
        this.articolo=articolo;
    }
    
    public Object getArticolo(){
        return articolo;
    }

	@Override
	public String toString() {
		return "L'utente "+ utente.getNome() +" "+ utente.getCognome() + " ha noleggiato l'articolo " + articolo;
	}
    
    
    
}