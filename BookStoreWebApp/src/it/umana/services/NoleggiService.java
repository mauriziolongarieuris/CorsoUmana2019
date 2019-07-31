package it.umana.services;

import it.umana.articoli.Articolo;
import it.umana.noleggi.Noleggio;
import it.umana.noleggi.Utente;
import it.umana.persistence.BibliotecaDataStore;

public class NoleggiService {
	
	public void noleggiaArticolo(String idUtente, String codiceArticolo) {
		Articolo a = null;		
		for (Articolo articolo : BibliotecaDataStore.getGiacenze()) {
			if(articolo.getCodice().equals(codiceArticolo)) {
				a = articolo;
				break;
			}
		}
		
		Utente u = null;
		for (Utente utente : BibliotecaDataStore.getUtenti()) {
			if(utente.getId() == Integer.parseInt(idUtente)) {
				u=utente;
			}
		}

		BibliotecaDataStore.aggiungiNoleggio(new Noleggio<Articolo>(u, a));
		BibliotecaDataStore.getGiacenze().remove(a);
		BibliotecaDataStore.salvaGiacenze();
	}
	
}
