package it.umana.persistence;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import it.umana.articoli.Articolo;
import it.umana.noleggi.Noleggio;
import it.umana.noleggi.Utente;
import it.umana.services.ArticoliService;
import it.umana.services.UtentiService;

public class BibliotecaDataStore {
	public static final String FILES_PATH = "C:\\Users\\longari\\Projects\\workspaces\\Local\\JAVA_CORE\\files\\";
	private static final String GIACENZE_DB_FILENAME = "giacenze.db";
	private static final String NOLEGGI_DB_FILENAME = "noleggi.db";
	
	private static List<Articolo> giacenze = new ArrayList<Articolo>();
	private static List<Utente> utenti = new ArrayList<Utente>();
	private static List<Noleggio<?>> noleggi = new ArrayList<Noleggio<?>>();
	
	public static void startDataStore() {
		System.out.println("Carico gli utenti");
		UtentiService utentiService = new UtentiService();
		utentiService.caricaUtenti(utenti);
		
		System.out.println("Carico le giacenze");
        caricaGiacenze();
        
		System.out.println("Carico i noleggi");
        caricaNoleggi();
        
        ArticoliService articoliService = new ArticoliService();
        articoliService.caricaArticoli(giacenze);
        
	}
	
	public static void stopDataStore() {		
		System.out.println("Salvo le giacenze");
        salvaGiacenze();
		System.out.println("Salvo i noleggi");
        salvaNoleggi();
	}

	public static List<Articolo> getGiacenze() {
		return giacenze;
	}

	public static void setGiacenze(List<Articolo> giacenze) {
		BibliotecaDataStore.giacenze = giacenze;
	}

	public static List<Utente> getUtenti() {
		return utenti;
	}

	public static void setUtenti(List<Utente> utenti) {
		BibliotecaDataStore.utenti = utenti;
	}

	public static List<Noleggio<?>> getNoleggi() {
		return noleggi;
	}

	public static void setNoleggi(List<Noleggio<?>> noleggi) {
		BibliotecaDataStore.noleggi = noleggi;
	}
	
	public static void aggiungiNoleggio(Noleggio<?> noleggio) {
		noleggi.add(noleggio);
		salvaNoleggi();
	}
	
	
	public static void salvaGiacenze() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BibliotecaDataStore.FILES_PATH + GIACENZE_DB_FILENAME))){
			for(Articolo g: giacenze) {
        		oos.writeObject(g);
	        }
        }catch (Exception e) {
		    e.printStackTrace();
		}
	}	

	private static void caricaGiacenze( ) {
		try {
			FileInputStream fileInputStream = new FileInputStream(BibliotecaDataStore.FILES_PATH + GIACENZE_DB_FILENAME);
			if(fileInputStream.available()>0) {
				ObjectInputStream ois = new ObjectInputStream(fileInputStream);
				Articolo a=null;
				while((a = (Articolo)ois.readObject())!=null) {
					giacenze.add(a);
				}
				ois.close();
			}
        } 
		catch (EOFException e) {
        	// do nothing
		} 
		catch (Exception e) {
		    e.printStackTrace();
		}
	}	
	
	
	private static void salvaNoleggi() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BibliotecaDataStore.FILES_PATH + NOLEGGI_DB_FILENAME))){
			for(Noleggio<?> g: noleggi) {
        		oos.writeObject(g);
	        }
        }catch (Exception e) {
		    e.printStackTrace();
		}
	}	

	private static void caricaNoleggi( ) {
		try {
			FileInputStream fileInputStream = new FileInputStream(BibliotecaDataStore.FILES_PATH + NOLEGGI_DB_FILENAME);
			if(fileInputStream.available()>0) {
				ObjectInputStream ois = new ObjectInputStream(fileInputStream);
				Noleggio<?> a=null;
				while((a = (Noleggio<?>)ois.readObject())!=null) {
					noleggi.add(a);
				}
				ois.close();
			}
        }
		catch (EOFException e) {
        	// do nothing
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	}	
	
}
