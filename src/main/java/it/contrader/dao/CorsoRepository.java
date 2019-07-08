package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.Corso;
import  java.util.List;

@Repository
public interface CorsoRepository extends CrudRepository <Corso, Integer> {
	// trova tutti i corsi
	@Query("FROM Corso")
    public List<Corso> findAll();
	
	// mostra solo i nomi
	@Query("FROM Corso")
	public List<Corso> findCorsoNome();
	
	// cerca solo i corsi di matematica I
	@Query("FROM Corso C WHERE C.nome = 'Matematica I'")
	public List<Corso> findCorsoMatematica();
	
	// ricerca in base all'id
	@Query("SELECT C FROM Corso C WHERE C.id = :id")
	public Corso findCorsoById(int id);
	
	// ricerca in base ad una parte del nome passato come argomento
	@Query("SELECT C FROM Corso C WHERE C.nome like %:nome%")
	public List<Corso> findCorsoByNome(String nome);

}