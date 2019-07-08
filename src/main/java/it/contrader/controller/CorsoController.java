package it.contrader.controller;

import it.contrader.model.Corso;
import it.contrader.dao.CorsoRepositoryCriteria;
import it.contrader.service.ICorsoService;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Corso")
public class CorsoController {
	
	@Autowired
    ICorsoService corsoService;
	
	@Autowired
	EntityManager em;

	// HQL
	@RequestMapping(value="/showAllCorsi", method = RequestMethod.GET)
	public String findAllCorso(HttpServletRequest request) {
        List<Corso> corsi = (List<Corso>) this.corsoService.findAll();
        request.getSession().setAttribute("corsi", corsi);
        return "showCorsi";
    }
	
	// CRITERIA
	@RequestMapping(value="/showAllCorsiCriteria", method = RequestMethod.GET)
	public String findAllCorsoCriteria(HttpServletRequest request) {
		CorsoRepositoryCriteria cRC = new CorsoRepositoryCriteria(em); 
        List<Corso> corsi = cRC.findAllCorso();
        request.getSession().setAttribute("corsi", corsi);
        return "showCorsi";
    }
	
	// HQL
	@RequestMapping(value="/nomeCorso", method = RequestMethod.GET)
	public String findCorsoNome(HttpServletRequest request) {
        List<Corso> corsiNome = (List<Corso>) this.corsoService.findCorsoNome();
        request.getSession().setAttribute("corsiNome", corsiNome);
        return "corsoNomi";
    }
	
	// CRITERIA 
	@RequestMapping(value="/nomeCorsoCriteria", method = RequestMethod.GET)
	public String findCorsoNomeCriteria(HttpServletRequest request) {
		CorsoRepositoryCriteria cRC = new CorsoRepositoryCriteria(em); 
		List<String> corsiNome = (List<String>) cRC.findCorsoNome();
		request.getSession().setAttribute("corsiNome", corsiNome);
        return "corsoNomiCriteria";
    }
	
	// HQL
	@RequestMapping(value="/matematicaCorso", method = RequestMethod.GET)
	public String findCorsoMatematica(HttpServletRequest request) {
        List<Corso> corsoMatematica = (List<Corso>) this.corsoService.findCorsoMatematica();
        request.getSession().setAttribute("corsiMatematica", corsoMatematica);
        return "corsoMatematica";
    }
	
	// CRITERIA
	@RequestMapping(value="/matematicaCorsoCriteria", method = RequestMethod.GET)
	public String findCorsoMatematicaCriteria(HttpServletRequest request) {
		CorsoRepositoryCriteria cRC = new CorsoRepositoryCriteria(em);
        List<Corso> corsoMatematica = (List<Corso>) cRC.findCorsoMatematica();
        request.getSession().setAttribute("corsiMatematica", corsoMatematica);
        return "corsoMatematica";
    }
	
	// HQL
	@RequestMapping(value="/corsoID", method = RequestMethod.GET)
	public String findCorsoById(HttpServletRequest request) {
		Corso corsoID = (Corso) this.corsoService.getCorsoById(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("corsoID", corsoID);
        return "idCorso";
    }
	
	// CRITERIA
	@RequestMapping(value="/corsoIDCriteria", method = RequestMethod.GET)
	public String findCorsoByIdCriteria(HttpServletRequest request) {
		CorsoRepositoryCriteria cRC = new CorsoRepositoryCriteria(em);
		Corso corsoID = (Corso) cRC.findCorsoById(Integer.parseInt(request.getParameter("id")));
		request.getSession().setAttribute("corsoID", corsoID);
		return "idCorso";
	}
	
	// HQL
	@RequestMapping(value="/corsoNomeRicerca", method = RequestMethod.GET)
	public String findCorsoByNome(HttpServletRequest request) {
		List<Corso> corsoNome = (List<Corso>) this.corsoService.getCorsoByNome(request.getParameter("nomeCorso"));
        request.getSession().setAttribute("corsoNome", corsoNome);
        return "showCorsoByName";
    }
	
	// CRITERIA
	@RequestMapping(value="/corsoNomeRicercaCriteria", method = RequestMethod.GET)
	public String findCorsoByNomeCriteria(HttpServletRequest request) {
		CorsoRepositoryCriteria cRC = new CorsoRepositoryCriteria(em);
		List<Corso> corsoNome = (List<Corso>) cRC.findCorsoByNome(request.getParameter("nomeCorso"));
		request.getSession().setAttribute("corsoNome", corsoNome);
		return "showCorsoByName";
	}
}