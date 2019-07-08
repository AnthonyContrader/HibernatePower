package it.contrader.dao;
import it.contrader.model.Corso;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CorsoRepositoryCriteria {
		
		public EntityManager entityManager;
		private CriteriaBuilder criteriaBuilder;
		
		public CorsoRepositoryCriteria(EntityManager em) {
			this.entityManager = em;
		}
	
		// mediante le cirteria query mostro tutta la tabella corso
		public List<Corso> findAllCorso() {
			this.criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Corso> criteriaQuery = criteriaBuilder.createQuery(Corso.class);
			Root<Corso> corsi = criteriaQuery.from(Corso.class);
			TypedQuery<Corso> query = entityManager.createQuery(criteriaQuery);
			return query.getResultList();
		}
		
		/*
		   mediante la criteria query mostro solo i nomi dell'entita Corso
		   come si può notare in questo caso il ritorno non è di tipo Corso, ma è del tipo del campo che si sta cercando di 
		   ottenere, che è di tipo string
		*/
		public List<String> findCorsoNome(){
			this.criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
			Root<Corso> corsiByName = criteriaQuery.from(Corso.class);
			criteriaQuery.select(corsiByName.<String>get("nome"));
			TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
			List<String> nomiCorsi = (List<String>) query.getResultList();
			return nomiCorsi;
		}
		
		// query che cerca solo il corso con nome Matematica I
		public List<Corso> findCorsoMatematica(){
			this.criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Corso> criteriaQuery = criteriaBuilder.createQuery(Corso.class);
			Root<Corso> corso = criteriaQuery.from(Corso.class);
			ParameterExpression<String> parametro = criteriaBuilder.parameter(String.class);
			criteriaQuery.select(corso).where(criteriaBuilder.equal(corso.get("nome"), parametro));
			TypedQuery<Corso> query = entityManager.createQuery(criteriaQuery);
			query.setParameter(parametro, "Matematica I");
			List<Corso> corsoMatematica = (List<Corso>) query.getResultList();
			return corsoMatematica;
		}
		
		/*
		 * Query che cerca i corsi in base all'id
		 */
		public Corso findCorsoById(int id) {
			this.criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Corso> criteriaQuery = criteriaBuilder.createQuery(Corso.class);
			Root<Corso> corso = criteriaQuery.from(Corso.class);
			ParameterExpression<Integer> parametro = criteriaBuilder.parameter(Integer.class);
			criteriaQuery.select(corso).where(criteriaBuilder.equal(corso.get("idCorso"), parametro));
			TypedQuery<Corso> query = entityManager.createQuery(criteriaQuery);
			query.setParameter(parametro, id);
			Corso corsoById = (Corso) query.getSingleResult();
			return corsoById;
		}
		
		/*
		 *  Query che cerca i corsi in base al nome del corso
		 */
		public List<Corso> findCorsoByNome(String nome) {
			this.criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Corso> criteriaQuery = criteriaBuilder.createQuery(Corso.class);
			Root<Corso> corso = criteriaQuery.from(Corso.class);
			ParameterExpression<String> parametro = criteriaBuilder.parameter(String.class);
			Predicate predicate = criteriaBuilder.like(corso.<String>get("nome"), parametro);
			criteriaQuery.select(corso).where(predicate);
			TypedQuery<Corso> query = entityManager.createQuery(criteriaQuery);
			query.setParameter(parametro, nome);
			List<Corso> corsoNome = (List<Corso>) query.getResultList();
			return corsoNome;
		}
}