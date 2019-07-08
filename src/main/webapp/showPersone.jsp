<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Persone</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>	
    	<div class="column content" id="visualizzazione">
    		<table class="table table-hover">
    			<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Cognome</th>
						<th scope="col">Indirizzo</th>
						<th scope="col">Nome</th>
					</tr>
				</thead>
    		
    		<tbody>
				<% List<Persona> persone = (List<Persona>) session.getAttribute("persone");
					if (persone != null) {
						for (int i = 0; i < persone.size(); i++) { %>
				<tr>
					<th scope="row">
						<% out.println(persone.get(i).getId()); %>
					</th>
					<td>
						<% out.println(persone.get(i).getCognome()); %>
					</td>
					<td>
						<% out.println(persone.get(i).getIndirizzo()); %>
					</td>
					<td>
						<% out.println(persone.get(i).getNome()); %>
					</td>
				
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<th scope="row">!!!</th>
					<td>Nessun oggetto rilevato</td>
				</tr>
				<%
					}
				%>
			</tbody>
			</table>
    	</div>
    </body>
</html>