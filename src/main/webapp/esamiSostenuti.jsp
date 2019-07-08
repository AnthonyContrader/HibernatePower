<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ESAMI SOSTENUTI</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>	
    	<div class="column content" id="visualizzazione">
    		<table  class="table table-hover"  height="50" valign="middle" border="2" bordercolor="blue" bordercolorlight="#00CCFF" bordercolordark="#000099">
    			<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Materia</th>
						<th scope="col">Voto</th>
					</tr>
				</thead>
    		
    		<tbody>
				<%
					List<EsamiSostenuti> esami = (List<EsamiSostenuti>) session.getAttribute("esamiSostenuti");
							if (esami != null) {
								for (int i = 0; i < esami.size(); i++) {
				%>
				<tr>
					<th scope="row">
						<% out.println(esami.get(i).getIdEsame()); %>
					</th>
					<td>
						<% out.println(esami.get(i).getMateria()); %>
					</td>
					<td>
						<% out.println(esami.get(i).getVoto()); %>
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