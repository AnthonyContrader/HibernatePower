package it.contrader.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Docente;
import java.util.List;

@Repository
public interface DocenteRepository extends CrudRepository <Docente, Integer> {
	 
	@Query("FROM Docente")
    public List<Docente> findAll();
		
	//cerca tutti i docenti con email gmail
	@Query("SELECT D FROM Docente D WHERE D.email Like '%gmail%'")
	public List<Docente> findDocentiGmail();
	
	//ricerca docente per email e nome
	@Query("SELECT D FROM Docente D WHERE D.nome Like %:nome% AND D.email Like %:email%")
	public List<Docente> findDocenteNomeEmail(String nome, String email);	
}