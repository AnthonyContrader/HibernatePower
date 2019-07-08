package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.EsamiSostenuti;

import java.util.Date;
import  java.util.List;

@Repository
public interface EsameRepository extends CrudRepository <EsamiSostenuti, Integer>{
	
	@Query("FROM EsamiSostenuti")
	public List<EsamiSostenuti> findAll();
	
	@Query("SELECT avg(e.voto) FROM EsamiSostenuti e")
	public int findAllMediaEsami();
	
	@Query("SELECT sum(e.voto) FROM EsamiSostenuti e")
	public int findAllSumEsami();
	
	@Query("SELECT E FROM EsamiSostenuti E WHERE E.data = :data")
	public List<EsamiSostenuti> findEsamiByYear(Date data);

	@Query("SELECT E FROM EsamiSostenuti E WHERE E.data BETWEEN :start AND :end")
	public List<EsamiSostenuti> findEsamiByInterval(Date start, Date end);
	
	@Query("SELECT E FROM EsamiSostenuti E WHERE E.data <= :date")
	public List<EsamiSostenuti> findEsamyByDateBefore(Date date);	
		
}