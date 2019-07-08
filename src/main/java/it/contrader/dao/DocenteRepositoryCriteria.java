package it.contrader.dao;

import it.contrader.model.Docente;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DocenteRepositoryCriteria {
		
	public EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	
	public DocenteRepositoryCriteria(EntityManager em) {
		this.entityManager = em;
	}
	
	public List<Docente> findAllDocente() {
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Docente> criteriaQuery = criteriaBuilder.createQuery(Docente.class);
		Root<Docente> docenti = criteriaQuery.from(Docente.class);
		TypedQuery<Docente> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}	
}