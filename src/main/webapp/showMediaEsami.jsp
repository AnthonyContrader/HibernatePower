<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Esami </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>	
    	<h4> La media dei voti degli esami: </h4> 
    	<div> <% int media = (int) session.getAttribute("mediaEsami"); out.println(media); %></div>
    	<h4> La somatoria dei voti degli esami: </h4> 
    	<div> <% int sommatoria = (int) session.getAttribute("sommaEsami"); out.println(sommatoria); %></div>
    </body>
</html>