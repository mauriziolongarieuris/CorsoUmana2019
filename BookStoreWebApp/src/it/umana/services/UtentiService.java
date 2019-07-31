package it.umana.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import it.umana.noleggi.Utente;
import it.umana.persistence.BibliotecaDataStore;

public class UtentiService {
	private static final String UTENTI_FILENAME = "Utenti.txt";

	
	public void caricaUtenti(List<Utente> utenti) {
       //lettura Utenti
		try(BufferedReader r = new BufferedReader(new FileReader(BibliotecaDataStore.FILES_PATH + UTENTI_FILENAME))){
			String line;
			while ( (line= r.readLine()) !=null ) {
				String[] userStrings = line.split(";");
				utenti.add(new Utente(
						 Integer.parseInt(userStrings[0]),
						 userStrings[1],
						 userStrings[2],
						 userStrings[3],
						 Integer.parseInt(userStrings[4]),
						 userStrings[5],
						 userStrings[6]
					)
				);
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}


}
