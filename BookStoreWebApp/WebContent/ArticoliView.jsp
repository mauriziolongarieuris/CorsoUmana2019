<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.umana.articoli.Articolo"%>
<%@page import="it.umana.articoli.ArticoloEditoriale"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articoli presenti</title>
</head>
<body>
	<h1>Articoli presenti</h1>
	<table>
	<% 
		List<Articolo> giacenze = (ArrayList<Articolo>)request.getAttribute("giacenze");
	 	 
	    for(Articolo giacenza : giacenze)
	    {
	    	out.print("<tr>");
	    	out.print("<td>");
	        out.print("Articolo: " + giacenza);
	        out.print("</td>");
	        out.print("</tr>");
	    }
	 	
	%>
	</table>
</body>
</html>