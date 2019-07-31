<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.umana.noleggi.*"%>
<%@page import="it.umana.articoli.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Noleggi</title>
</head>
<body>
	<h1>Noleggi</h1>
	Aggiungi noleggio:
	<form method="post" name="FormNoleggia" action="Noleggi">
		Seleziona articolo: <select name="codiceArticolo">
		<% 
			List<Articolo> giacenze = (ArrayList<Articolo>)request.getAttribute("giacenze"); 
			for(Articolo giacenza : giacenze)
		    {
				String value = null;
				if(giacenza instanceof ArticoloEditoriale) {
					value = ((ArticoloEditoriale)giacenza).getTitolo();
				} else {
					value = ((Gadget)giacenza).getDescrizione();
				}
				out.print("<option value=\"" +giacenza.getCodice()+"\">"+value+"</option>");
		    }
		%>
		</select>
		Seleziona utente: <select name="idUtente">
		<% 
			List<Utente> utenti = (ArrayList<Utente>)request.getAttribute("utenti");
		    for(Utente utente : utenti)
		    {
		    	out.print("<option value=\"" +utente.getId()+"\">"+utente.getNome()+" "+utente.getCognome()+"</option>");
		    }
	    %>
		</select>
		
		<input type="submit" value="Noleggia" />
	</form>
	Lista dei noleggi:
	<table border="1">
	<% 
		List<Noleggio> noleggi = (ArrayList<Noleggio>)request.getAttribute("noleggi");
	 	 
		out.print("<tr><td><b>Utente</b></td><td><b>Articolo</b></td></tr>");
	    for(Noleggio noleggio : noleggi)
	    {
	    	out.print("<tr>");
	    	out.print("<td>");
	        out.print(noleggio.getUtente().getNome() + " "+ noleggio.getUtente().getCognome());
	        out.print("</td>");
	        out.print("<td>");
	        out.print(noleggio.getArticolo());
	        out.print("</td>");
	        out.print("</tr>");
	    }
	 	
	%>
	</table>
</body>
</html>