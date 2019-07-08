package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Studente;
import it.contrader.model.EsamiSostenuti;
import  java.util.List;

@Repository
public interface StudenteRepository extends CrudRepository <Studente, Integer> {
	@Query("FROM Studente")
    public List<Studente> findAll();
	
	@Query("SELECT S FROM Studente S WHERE S.id = :id")
	public Studente findStudenteById(int id);
	
	@Query("SELECT S FROM Studente S WHERE S.nome = :nome")
	public List<Studente> findStudenteByName(String nome);
	
	@Query("SELECT S FROM Studente S WHERE S.cognome = :cognome")
	public List<Studente> findStudenteByCognome(String cognome);
	
	@Query("SELECT S.id FROM Studente S WHERE S.nome = :nome")
	public int findIdStudenteByName(String nome);
	
	/*
	 Stiamo interrogando la tabella esami sostenuti. Al fine di riferirci alla colonna id della chiave esterna dobbiamo esplictiamente 
	 informare il sistema che stiamo parlando dell'oggetto studente collegato alla stessa mediante FK. Quindi dobbiamo indicare E.studente.id.
	 Viceversa se indicassimo E.id il sistema si riferirebbe alla id della tabella oggetto della interrogazione. Nonostante il suo id si chiami 
	 id_Esame.
	*/
	@Query("SELECT E FROM EsamiSostenuti E WHERE E.studente.id = :idStud")
	public List<EsamiSostenuti> findEsamiSostenutiByIdStudente(int idStud);		
}