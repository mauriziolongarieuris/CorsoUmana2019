<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.umana.noleggi.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utenti</title>
</head>
<body>
	<h1>Utenti</h1>
	<table>
	<% 
		List<Utente> utenti = (ArrayList<Utente>)request.getAttribute("utenti");
	 	 
	    for(Utente utente : utenti)
	    {
	    	out.print("<tr>");
	    	out.print("<td>");
	        out.print("Utente: " + utente);
	        out.print("</td>");
	        out.print("</tr>");
	    }
	 	
	%>
	</table>
</body>
</html>