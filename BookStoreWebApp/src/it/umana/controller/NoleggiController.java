package it.umana.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.umana.articoli.Articolo;
import it.umana.noleggi.Noleggio;
import it.umana.noleggi.Utente;
import it.umana.persistence.BibliotecaDataStore;
import it.umana.services.NoleggiService;

/**
 * Servlet implementation class NoleggiController
 */
@WebServlet("/Noleggi")
public class NoleggiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoleggiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> attributeNames = request.getAttributeNames();
		List<Noleggio<?>> noleggi = null;
		List<Articolo> giacenze = null;
		List<Utente> utenti = null;
		
		if(!attributeNames.hasMoreElements()) {
			noleggi = BibliotecaDataStore.getNoleggi();
			giacenze = BibliotecaDataStore.getGiacenze();
			utenti = BibliotecaDataStore.getUtenti();
		}
		request.setAttribute("noleggi", noleggi);
		request.setAttribute("giacenze", giacenze);
		request.setAttribute("utenti", utenti);
		
		request.getRequestDispatcher("NoleggiView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codiceArticolo = request.getParameter("codiceArticolo");
	    String idUtente = request.getParameter("idUtente");
	    
	    NoleggiService noleggiService = new NoleggiService();
	    noleggiService.noleggiaArticolo(idUtente, codiceArticolo);	    
	    
		doGet(request, response);
	}

}
