package it.contrader.dao;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import it.contrader.model.Corso;
import it.contrader.util.HibernateUtil;
import java.util.List;

public class CriteriaRepository {
	
	public List<Corso> getAllCorso(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder(); 
		CriteriaQuery<Corso> criteria = builder.createQuery(Corso.class); 
		Root<Corso> root = criteria.from(Corso.class);
		criteria.select(root);
		List<Corso> corsi = session.createQuery(criteria).getResultList();
		session.close();
        return corsi;
	}
}