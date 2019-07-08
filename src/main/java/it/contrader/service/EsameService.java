package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.dao.EsameRepository;
import it.contrader.model.EsamiSostenuti;
import it.contrader.service.IEsameService;

import java.util.Date;
import java.util.List;

@Service
public class EsameService implements IEsameService {
	
	@Autowired
	private EsameRepository repository;
	
	@Override
	public List<EsamiSostenuti> findAll() {
	   List<EsamiSostenuti> esami = (List<EsamiSostenuti>) repository.findAll();
	   return esami;
	}
	
	@Override
	public int[] findMediaSomma() {
		int[] ris = new int[2];
		ris[0] = repository.findAllMediaEsami();
		ris[1] = repository.findAllSumEsami();
		return ris;
	}

	@Override
	public List<EsamiSostenuti> findEsameByYear(Date data){
		List<EsamiSostenuti> esami = (List<EsamiSostenuti>) repository.findEsamiByYear(data);
		return esami;
	}
	
	@Override
	public List<EsamiSostenuti> findEsamiByInterval(Date start, Date end){
		List<EsamiSostenuti> esami = (List<EsamiSostenuti>) repository.findEsamiByInterval(start, end);
		return esami;
	}
	
	@Override
	public List<EsamiSostenuti> findEsamiByDateBefore(Date date){
		List<EsamiSostenuti> esami = (List<EsamiSostenuti>) repository.findEsamyByDateBefore(date);
		return esami;
	}
	
	/*
	 * Questo metodo lo utilizziamo per poter eseguire un inserimento. Utilizziamo il metodo save già integrato nella repository. 
	 * NOn dobbiamo implementarlo, in quanto nativo della CrudRepository che estendiamo. Perche non abbiamo usato una query HQL per 
	 * effettuare un insierimento? Per il semplice motivo che non è possibile immettere delle query con valori in HQL. HQl non è studiato per 
	 * poter immettere dati. Ma questi si possono immettere solo effettuando un traferimento dati tra entità. In altre parole in HQl è previsto 
	 * il INSERT INTO ...SELECT... e non INSERT INTO...VALUES... Per questo abbiamo fatto ricorso alle query di CrudRepository per inserire un
	 * esame all'interno della tabella. 
	 */
	public boolean inserisciEsame(EsamiSostenuti eS) {
		return repository.save(eS) !=null;
	}

}