package it.contrader.controller;

import it.contrader.model.Studente;
import it.contrader.model.EsamiSostenuti;
import it.contrader.service.IStudenteService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Studente")
public class StudenteController {
	@Autowired
    IStudenteService studenteService;
	
	// HQL
	@RequestMapping(value="/showAllStudenti", method = RequestMethod.GET)
	public String findAllStudenti(HttpServletRequest request) {
        List<Studente> studenti = (List<Studente>) this.studenteService.findAll();
        request.getSession().setAttribute("studenti", studenti);
        return "showStudenti";
    }
	
	// HQL
	@RequestMapping(value="/studenteID", method = RequestMethod.GET)
	public String findStudenteById(HttpServletRequest request) {
		Studente studenteID = (Studente) this.studenteService.getStudenteById(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("studenteID", studenteID);
        return "idStudente";
    }
	
	// HQL mai utilizzato 
	@RequestMapping(value="/nomeStudente", method = RequestMethod.GET)
	public String findStudenteNome(HttpServletRequest request) {
        List<Studente> studenteNome = (List<Studente>) this.studenteService.getStudenteByName(request.getParameter("nomeStudente"));
        request.getSession().setAttribute("studenteNome", studenteNome);
        return "showStudenti";
    }
	
	// HQL
	@RequestMapping(value="/findEsamiByNomeStudente", method = RequestMethod.GET)
	public String findEsameByNomeStudente(HttpServletRequest request) {
        List<EsamiSostenuti> esamiSostenuti = (List<EsamiSostenuti>) this.studenteService.findEsamiSostenutiByStudenteName(request.getParameter("nomeStudente"));
        request.getSession().setAttribute("esamiSostenuti", esamiSostenuti);
        return "esamiSostenuti";
    }
}