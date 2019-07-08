<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Corsi</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>	
    	<div class="column content" id="visualizzazione">
    		<table class="table table-hover"  height="50" valign="middle" border="2" bordercolor="blue" bordercolorlight="#00CCFF" bordercolordark="#000099">
    			<thead>
					<tr>
						<th scope="col">Name</th>
					</tr>
				</thead>
    		
    		<tbody>
				<% List<Corso> corsi = (List<Corso>) session.getAttribute("corsiNome");
					if (corsi != null) {
						for (int i = 0; i < corsi.size(); i++) { %>
				<tr>
					<th scope="row">
						<% out.println(corsi.get(i).getNome()); %>
					</th>
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