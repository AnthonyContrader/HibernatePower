package it.contrader.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.dao.CorsoRepository;
import it.contrader.model.Corso;
import it.contrader.service.ICorsoService;
import java.util.List;

@Service
public class CorsoService implements ICorsoService {
	
	@Autowired
	private CorsoRepository repository;
	  
	@Override
	public List<Corso> findAll() {
	   List<Corso> corsi = (List<Corso>) repository.findAll();
	   return corsi;
	}
	
	@Override
	public List<Corso> findCorsoNome() {
	   List<Corso> corsiNomi = (List<Corso>) repository.findCorsoNome();
	   return corsiNomi;
	}
	
	@Override
	public List<Corso> findCorsoMatematica() {
	   List<Corso> corsoMatematica = (List<Corso>) repository.findCorsoMatematica();
	   return corsoMatematica;
	}
	
	@Override
	public Corso getCorsoById(int id) {
	   Corso corsoById = (Corso) repository.findCorsoById(id);
	   return corsoById;
	}
	
	@Override
	public List<Corso> getCorsoByNome(String nome) {
	   List<Corso> corsoByNome = (List<Corso>) repository.findCorsoByNome(nome);
	   return corsoByNome;
	}
}