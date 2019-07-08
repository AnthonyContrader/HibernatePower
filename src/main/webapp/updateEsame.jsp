<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.model.*"%>
<!DOCTYPE html>
<html>
	<head>
        <title>Update Esame</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    	<form action="/Esame/updEsame" method="get" enctype="multipart/form-data"  height="50" valign="middle" border="2" bordercolor="blue" bordercolorlight="#00CCFF" bordercolordark="#000099">
    		<div class="form-group">
    			<label class="form-label"> Data </label>
    			<input type="text" class="form-control" name="data" placeholder="dd/mm/yyyy" required autofocus>
                
                <label class="form-label"> Materia </label>
                <select class="form-control" name ="materia" required autofocus>
                  	<%  List<Corso> list = (List<Corso>) session.getAttribute("corsi");
                     		for(int i=0; i<list.size(); i++){
                     			%><option value ="<%out.println(list.get(i).getNome());%>"> <%out.println(list.get(i).getNome());%></option><%
                     	}
                 	 %>
               	</select>
                <label class="form-label"> Voto </label>
                <input type="number" name="voto" min="18" max="30">
        		
        		<label class="form-label"> Studente </label>
                <select class="form-control" id = "studente" name ="idStudente" required autofocus>
                  	<%  List<Studente> list2 = (List<Studente>) session.getAttribute("studenti");
                     		for(int i=0; i<list2.size(); i++){
                     			%><option value ="<%out.println(list2.get(i).getId());%>"> <%out.println(list2.get(i).getCognome());%></option><%
                     	}
                 	 %>
               	</select>
  			    <button type="submit">Aggiorna Esame</button>
  			</div>
    		</div>
    	</form>
    </body>
</html>