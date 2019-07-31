package it.umana.services;

import java.util.List;

import it.umana.articoli.Articolo;
import it.umana.articoli.Catalogatore;

public class ArticoliService {
	
	private static final String DISTINTA_ARTICOLI_FILENAME_PREFIX = "Distinta";
	
	public void caricaArticoli(List<Articolo> giacenze) {
		Catalogatore catalogatore1 = new Catalogatore(DISTINTA_ARTICOLI_FILENAME_PREFIX+".txt", giacenze);
		catalogatore1.start();
	}
	
}
