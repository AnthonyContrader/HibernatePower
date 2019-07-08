package it.contrader.service;

import java.util.Date;
import java.util.List;
import it.contrader.model.EsamiSostenuti;

public interface IEsameService {
	List<EsamiSostenuti> findAll(); 
	int[] findMediaSomma();
	List<EsamiSostenuti> findEsameByYear(Date date);
	List<EsamiSostenuti> findEsamiByInterval(Date start, Date end);
	List<EsamiSostenuti> findEsamiByDateBefore(Date date);
	//EsamiSostenuti updateVotoEsame(int id);
}