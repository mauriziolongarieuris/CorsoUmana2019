package it.umana.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.umana.articoli.Articolo;
import it.umana.persistence.BibliotecaDataStore;

/**
 * Servlet implementation class ArticoliController
 */
public class ArticoliController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ArticoliController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> attributeNames = request.getAttributeNames();
		List<Articolo> giacenze = null;
		if(!attributeNames.hasMoreElements()) {
			// return the list of all articles with theirs availability
			giacenze = BibliotecaDataStore.getGiacenze();
		}
		request.setAttribute("giacenze", giacenze);
		request.getRequestDispatcher("ArticoliView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
