package it.contrader.controller;

import it.contrader.dao.CorsoRepositoryCriteria;
import it.contrader.dao.DocenteRepositoryCriteria;
import it.contrader.model.Corso;
import it.contrader.model.Docente;
import it.contrader.service.IDocenteService;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Docente")
public class DocenteController {
	
	@Autowired
	IDocenteService docenteService;
	
	@Autowired
	EntityManager em;
	
	// HQL
	@RequestMapping(value="/showAllDocenti", method = RequestMethod.GET)
	public String findAllDocenti(HttpServletRequest request) {
        List<Docente> docenti = (List<Docente>) this.docenteService.findAll();
        request.getSession().setAttribute("docenti", docenti);
        return "showDocenti";
    }
	
	// CRITERIA
	@RequestMapping(value="/showAllDocentiCriteria", method = RequestMethod.GET)
	public String findAllDocenteCriteria(HttpServletRequest request) {
		DocenteRepositoryCriteria dRC = new DocenteRepositoryCriteria(em); 
	    List<Docente> docente = dRC.findAllDocente();
	    request.getSession().setAttribute("docenti", docente);
	    return "showDocenti";
	}
	
	// HQL
	@RequestMapping(value="/showAllDocentiGmail", method = RequestMethod.GET)
	public String findAllGmail(HttpServletRequest request) {
        List<Docente> docentiGmail = (List<Docente>) this.docenteService.findDocentiGmail();
        request.getSession().setAttribute("docentiGmail", docentiGmail);
        return "showDocentiGmail";
    }
	
	// HQL
	@RequestMapping(value="/showAllDocentiNomeEmail", method = RequestMethod.GET)
	public String findAllNomeEmail(HttpServletRequest request) {
		String nome = request.getParameter("nomeDocente");
		String email = request.getParameter("emailDocente");
		List<Docente> doceNomeEmail = (List<Docente>) this.docenteService.findDocenteNomeEmail(nome, email);
        request.getSession().setAttribute("doceNomeEmail", doceNomeEmail);
        return "showDoceNomeEmail";
    }
}