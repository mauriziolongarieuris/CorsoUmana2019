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
import it.umana.noleggi.Utente;
import it.umana.persistence.BibliotecaDataStore;

/**
 * Servlet implementation class UtentiController
 */
@WebServlet("/Utenti")
public class UtentiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtentiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramenterNames = request.getParameterNames();
		List<Utente> utenti = null;
		if(!paramenterNames.hasMoreElements()) {
			// return the list of all articles with theirs availability
			utenti = BibliotecaDataStore.getUtenti();
		}
		request.setAttribute("utenti", utenti);
		request.getRequestDispatcher("UtentiView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
