package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.dao.PersoneRepository;
import it.contrader.model.Persona;
import it.contrader.service.IPersonaService;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	private PersoneRepository repository;
	  
	@Override
	public List<Persona> findAll() {
	   List<Persona> persone = (List<Persona>) repository.findAll();
	   return persone;
	}
}