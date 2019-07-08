package it.contrader.controller;

import it.contrader.model.EsamiSostenuti;
import it.contrader.model.Studente;
import it.contrader.model.Corso;
import it.contrader.service.EsameService;
import it.contrader.service.StudenteService;
import it.contrader.service.CorsoService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Esame")
public class EsameController {
	
	private final EsameService esameService;
	private final StudenteService studenteService;
	private final CorsoService corsoService;
	private Integer idEsameUpdate;
	
	@Autowired
	public EsameController(EsameService esameService, StudenteService  studenteService, CorsoService corsoService) {
		this.esameService = esameService;
		this.studenteService = studenteService;
		this.corsoService = corsoService;
	}
	
	// HQL
	@RequestMapping(value="/showAllEsami", method = RequestMethod.GET)
	public String findAllEsami(HttpServletRequest request) {
        List<EsamiSostenuti> esame = (List<EsamiSostenuti>) this.esameService.findAll();
        request.getSession().setAttribute("esame", esame);
        return "showEsami";
    }
	
	// HQL
	@RequestMapping(value="/showMediaEsami", method = RequestMethod.GET)
	public String findMediaEsami(HttpServletRequest request) {
        int [] ris = (int[]) this.esameService.findMediaSomma();
        request.getSession().setAttribute("mediaEsami", ris[0]);
        request.getSession().setAttribute("sommaEsami", ris[1]);
        return "showMediaEsami";
    }
	
	// HQL
	@RequestMapping(value="/vaiASchedaInserimentoEsame", method = RequestMethod.GET)
	public String findAllStudenti(HttpServletRequest request) {
        List<Studente> studenti = (List<Studente>) this.studenteService.findAll();
        request.getSession().setAttribute("studenti", studenti);
        List<Corso> corsi = (List<Corso>) this.corsoService.findAll();
        request.getSession().setAttribute("corsi", corsi);  
        return "inserisciEsame";
    }
	
	// HQL
	@RequestMapping(value ="/insEsame", method = RequestMethod.GET)
	public String inserisciEsame(HttpServletRequest request) {
		Date data =  this.convertStringToDate(request.getParameter("data"));
		String materia = (String) request.getParameter("materia");
		int voto = (int) Integer.parseInt(request.getParameter("voto"));
		int idStudente = (int) Integer.parseInt(request.getParameter("idStudente").trim());
		Studente studente = (Studente) this.studenteService.getStudenteById(idStudente);
		Integer idEsame=0; 
		EsamiSostenuti es = (EsamiSostenuti) new EsamiSostenuti(idEsame, voto, materia, data, studente);
		this.esameService.inserisciEsame(es);
		return "index";		
	}
	
	// HQL
	@RequestMapping(value ="/aggiornaEsame", method = RequestMethod.GET)
	public String aggiornaEsame(HttpServletRequest request) {
		idEsameUpdate = (Integer) Integer.parseInt(request.getParameter("idEsame"));
		List<Studente> studenti = (List<Studente>) this.studenteService.findAll();
        request.getSession().setAttribute("studenti", studenti);
        List<Corso> corsi = (List<Corso>) this.corsoService.findAll();
        request.getSession().setAttribute("corsi", corsi); 
		return "updateEsame";		
	}
	
	// HQL
	@RequestMapping(value ="/updEsame", method = RequestMethod.GET)
	public String updateEsame(HttpServletRequest request) {
		Date data =  this.convertStringToDate(request.getParameter("data"));
		String materia = (String) request.getParameter("materia");
		int voto = (int) Integer.parseInt(request.getParameter("voto"));
		int idStudente = (int) Integer.parseInt(request.getParameter("idStudente").trim());
		Studente studente = (Studente) this.studenteService.getStudenteById(idStudente);
		EsamiSostenuti es = (EsamiSostenuti) new EsamiSostenuti(idEsameUpdate, voto, materia, data, studente);
		this.esameService.inserisciEsame(es);
		return "index";		
	}
	
	// HQL
	@RequestMapping(value="/showEsamiByYear", method = RequestMethod.GET)
	public String findEsamiByYear(HttpServletRequest request) {
		Date sqlDate =  this.convertStringToDate(request.getParameter("data"));
		List<EsamiSostenuti> esame = (List<EsamiSostenuti>) this.esameService.findEsameByYear(sqlDate);
		request.getSession().setAttribute("esame", esame);
		return "showEsami";
    }

	// HQL
	@RequestMapping(value="/showEsamiByInterval", method = RequestMethod.GET)
	public String findEsamiByInterval(HttpServletRequest request) {
		Date start =  this.convertStringToDate(request.getParameter("start"));
		Date end =  this.convertStringToDate(request.getParameter("end"));
		List<EsamiSostenuti> esame = (List<EsamiSostenuti>) this.esameService.findEsamiByInterval(start, end);
		request.getSession().setAttribute("esame", esame);
		return "showEsami";
    }
	
	// HQL
	@RequestMapping(value="/showEsamiByDateBefore", method = RequestMethod.GET)
	public String findEsamiByDateBefore(HttpServletRequest request) {
		Date data =  this.convertStringToDate(request.getParameter("dateBefore"));
		List<EsamiSostenuti> esame = (List<EsamiSostenuti>) this.esameService.findEsamiByDateBefore(data);
		request.getSession().setAttribute("esame", esame);
		return "showEsami";
    }
	
	// HQL
	public Date convertStringToDate(String stringData)
	{
	    Date data = null;
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    try{
	        data = (Date) df.parse(stringData); 	
	    }
	    catch ( Exception ex ){
	        System.out.println(ex);
	    }
	    return data;
	}
	
	// HQL
	public String dataAdjust(String dataDaModifcare) {
		String anno = dataDaModifcare.substring(0, 4);
		String mese = dataDaModifcare.substring(5, 7);
		String giorno = dataDaModifcare.substring(8,10);
		String nuovaData = giorno+"/"+mese+"/"+anno;
		return nuovaData; 
	}
}