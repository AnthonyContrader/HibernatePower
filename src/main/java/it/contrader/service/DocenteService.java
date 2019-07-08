package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.dao.DocenteRepository;
import it.contrader.model.Docente;
import it.contrader.service.IDocenteService;
import java.util.List;

@Service
public  class DocenteService implements IDocenteService {
	
	@Autowired
	private DocenteRepository repository;
	
	@Override
	public List<Docente> findAll() {
	   List<Docente> docenti = (List<Docente>) repository.findAll();
	   return docenti;
	}
	
	@Override
	public List<Docente> findDocentiGmail() {
	   List<Docente> docentiGmail = (List<Docente>) repository.findDocentiGmail();
	   return docentiGmail;
	}
	
	@Override
	public List<Docente> findDocenteNomeEmail(String nome, String email) {
	   List<Docente> docentiNomeEmail = (List<Docente>) repository.findDocenteNomeEmail(nome, email);
	   return docentiNomeEmail;
	}
}