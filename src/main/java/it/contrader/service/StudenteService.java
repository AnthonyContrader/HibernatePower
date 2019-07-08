package it.contrader.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dao.StudenteRepository;
import it.contrader.model.Studente;
import it.contrader.model.EsamiSostenuti;
import it.contrader.service.IStudenteService;
import java.util.List;

@Service
public class StudenteService implements IStudenteService{
	
	@Autowired
	private StudenteRepository repository;
	
	@Override
	public List<Studente> findAll() {
	   List<Studente> studenti = (List<Studente>) repository.findAll();
	   return studenti;
	}
	
	@Override
	public Studente getStudenteById(int id) {
	   Studente studente = (Studente) repository.findStudenteById(id);
	   return studente;
	}
	
	@Override
	public List<Studente> getStudenteByName(String nome) {
		List<Studente> studente = (List<Studente>) repository.findStudenteByName(nome);
	   return studente;
	}
	
	// questo metodo sfrutta la capacità di HQL di vedere le entita come degli oggetti
	@Override
	public List<EsamiSostenuti> findEsamiSostenutiByStudenteName(String nome) {
		int id = (int) repository.findIdStudenteByName(nome);
		List<EsamiSostenuti> esamiSostenuti = (List<EsamiSostenuti>) repository.findEsamiSostenutiByIdStudente(id);
		return esamiSostenuti;
	}
	
	// metodo alternativo al precedente che sfrutta diversamente gli automatismi di hibernate. Sfrutta la relazione esistente, partendo dal presupposto
	// che un oggetto ingloba in se stesso la lista di oggetti a cui è collegato. All'atto pratico questo metodo ha poca utilita, ma ha una sua valenza 
	// per fini didattici.
	@Override
	public List<EsamiSostenuti> findEsamiSostenutiByStudenteName2(String nome) {
		Studente s =((List<Studente>) repository.findStudenteByCognome(nome)).get(0);
		List<EsamiSostenuti> esamiSostenuti = s.getEsamiSostenuti();
		return esamiSostenuti;
	}
}