<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Docenti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>	
    	<div class="column content" id="visualizzazione">
    		<table class="table table-hover"  height="50" valign="middle" border="2" bordercolor="blue" bordercolorlight="#00CCFF" bordercolordark="#000099">
    			<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Cognome</th>
						<th scope="col">Indirizzo</th>
						<th scope="col">Nome</th>
						<th scope="col">Email</th>
					</tr>
				</thead>
    		
    		<tbody>
				<% List<Docente> docenti = (List<Docente>) session.getAttribute("docentiGmail");
					if (docenti != null) {
						for (int i = 0; i < docenti.size(); i++) { %>
				<tr>
					<th scope="row">
						<% out.println(docenti.get(i).getId()); %>
					</th>
					<td>
						<% out.println(docenti.get(i).getCognome()); %>
					</td>
					<td>
						<% out.println(docenti.get(i).getIndirizzo()); %>
					</td>
					<td>
						<% out.println(docenti.get(i).getNome()); %>
					</td>
					<td>
						<% out.println(docenti.get(i).getEmail()); %>
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