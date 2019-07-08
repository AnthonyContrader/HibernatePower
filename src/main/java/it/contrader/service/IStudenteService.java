package it.contrader.service;

import java.util.List;
import it.contrader.model.Studente;
import it.contrader.model.EsamiSostenuti;

public interface IStudenteService {
	Studente getStudenteById(int id);
	
	List<Studente> findAll();
	List<Studente> getStudenteByName(String nome);
	List<EsamiSostenuti> findEsamiSostenutiByStudenteName(String nome);
	List<EsamiSostenuti> findEsamiSostenutiByStudenteName2(String nome);	
}