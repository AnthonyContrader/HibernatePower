package it.contrader.service;

import java.util.List;
import it.contrader.model.Docente;

public interface IDocenteService {
	List<Docente> findAll();
	List<Docente> findDocentiGmail();
	List<Docente> findDocenteNomeEmail(String nome, String email);
}