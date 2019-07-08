<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
   	</head>
    <body>
    	<h4>Progetto di esempio sull'utilizzo di:
    		Pagine JSP, Hibernate, query HQL e Criteria Query, pattern MVC (ad esclusione dei DTO). 
    	</h4>
        	<a href="/Corso/showAllCorsi">Tutti i corsi</a>
        <br></br>
        	<a href="/Corso/showAllCorsiCriteria">Tutti i corsi (Criteria)</a>
        <br></br>
        	<a href="/Corso/nomeCorso"> Motra solo Nomi</a>
        <br></br>
        	<a href="/Corso/nomeCorsoCriteria"> Motra solo Nomi (Criteria)</a>
        <br></br>
        	<a href="/Corso/matematicaCorso"> Corsi di Matematica I</a>
        <br></br>
        	<a href="/Corso/matematicaCorsoCriteria"> Corsi di Matematica I (Criteria)</a>
       	<br></br> 	
        <form action="/Corso/corsoID" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> ID </label>
        			<input type="text" class="form-control" name="id" required autofocus>
  					<button type="submit">Ricerca Corso Per ID</button>
            </div>
        </form>
        <br></br> 	
        <form action="/Corso/corsoIDCriteria" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> ID </label>
        			<input type="text" class="form-control" name="id" required autofocus>
  					<button type="submit">Ricerca Corso Per ID (Criteria)</button>
            </div>
        </form>    
        <br></br>
        <form action="/Corso/corsoNomeRicerca" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> Nome </label>
        			<input type="text" class="form-control" name="nomeCorso" required autofocus>
  					<button type="submit">Ricerca Corso Per Nome</button>
            </div>
        </form>
        <br></br>
        <form action="/Corso/corsoNomeRicercaCriteria" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> Nome </label>
        			<input type="text" class="form-control" name="nomeCorso" required autofocus>
  					<button type="submit">Ricerca Corso Per Nome (Criteria) </button>
            </div>
        </form>
        <br></br>
        	<a href="/Docente/showAllDocenti"> Mostra tutti i docenti </a>
        <br></br>
        	<a href="/Docente/showAllDocentiCriteria"> Mostra tutti i docenti (Criteria)</a>
        <br></br>
        	<a href="/Docente/showAllDocentiGmail"> Mostra tutti i docenti con email Gmail </a>
        <br></br>
        <form action="/Docente/showAllDocentiNomeEmail" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> Nome Docente </label>
        			<input type="text" class="form-control" name="nomeDocente" required autofocus>
        			<label class="form-control"> Email Docente </label>
        			<input type="text" class="form-control" name="emailDocente" required autofocus>
  					<button type="submit">Ricerca Docente per nome ed email</button>
            </div>
        </form>
        <br></br>
        	<a href="/Esame/showAllEsami"> Mostra tutti gli esami nel DB </a>
        <br></br>
        	<a href="/Esame/showMediaEsami"> Mostra la media e la sommatoria dei voti esami presenti nel DB </a>
        <br></br>
        	<a href="/Studente/showAllStudenti"> Mostra elenco studenti</a>
        <br></br>
        <form action="/Studente/findEsamiByNomeStudente" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> Immetti nome studente </label>
        			<input type="text" class="form-control" name="nomeStudente" required autofocus>
  					<button type="submit">Cerca Esami sostenuti Metodo 1</button>
            </div>
        </form>
        <br></br>
        <form action="/Studente/findEsamiByNomeStudente" method="get" enctype="multipart/form-data">
            <div class="form-group">
                    <label class="form-control"> Immetti nome studente </label>
        			<input type="text" class="form-control" name="nomeStudente" required autofocus>
  					<button type="submit">Cerca Esami sostenuti Metodo 2</button>
            </div>
        </form>
        <br></br>
        <form action="/Esame/showEsamiByYear" method="get" enctype="multipart/form-data" >
            <div class="form-group">
            		<font color="red">
            			<h4>Cerca gli esami sostenuti in base ad una data precisa</h4>
                    </font>
                    <label class="form-control" > Immetti data </label>
        			<input type="text" class="form-control" name="data" placeholder="dd/mm/yyyy" required autofocus>
  					<button type="submit">Cerca</button>
            </div>
        </form>
        <br></br>
        <form action="/Esame/showEsamiByInterval" method="get" enctype="multipart/form-data">
            <div class="form-group">
            		<font color="green">
            			<h4>Cerca gli esami sostenuti in base ad un intervallo temporale</h4>
                    </font>
                    <label class="form-control"> Immetti data inizio </label>
        			<input type="text" class="form-control" name="start" placeholder="dd/mm/yyyy" required autofocus>
        			<label class="form-control"> Immetti data fine </label>
        			<input type="text" class="form-control" name="end" placeholder="dd/mm/yyyy" required autofocus>
  					<button type="submit">Cerca</button>
            </div>
        </form>
        <br></br>
        <form action="/Esame/showEsamiByDateBefore" method="get" enctype="multipart/form-data">
            <div class="form-group">
            		<font color="blue">
            			<h4>Cerca gli esami sostenuti prima di una data</h4>
        			</font>
        			<label class="form-control"> Immetti data </label>
        			<input type="text" class="form-control" name="dateBefore" placeholder="dd/mm/yyyy" required autofocus>
  					<button type="submit">Cerca</button>
            </div>
        </form>
       	<br></br>	
        	<a href="/Esame/vaiASchedaInserimentoEsame" > Inserisci Esame </a>
    </body>
</html>