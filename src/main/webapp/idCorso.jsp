<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
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
    		<table class="table table-hover">
    			<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
					</tr>
				</thead>
    		
    		<tbody>
				<% Corso corso = (Corso) session.getAttribute("corsoID");%>
				<tr>
				<th scope="row">
					<% out.println(corso.getIdCorso()); %>
				</th>
				<td>
					<% out.println(corso.getNome()); %>
				</td>
				</tr>	
			</tbody>
			</table>
    	</div>
    </body>
</html>