package it.contrader.service;

import java.util.List;
import it.contrader.model.Corso;

public interface ICorsoService {
	Corso getCorsoById(int id);
	List<Corso> getCorsoByNome(String nome);
	List<Corso> findAll(); 
	List<Corso> findCorsoNome();
	List<Corso> findCorsoMatematica();	
}