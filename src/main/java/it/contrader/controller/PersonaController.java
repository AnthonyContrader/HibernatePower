package it.contrader.controller;

import it.contrader.model.Persona;
import it.contrader.service.IPersonaService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Persona")
public class PersonaController {

	@Autowired
    IPersonaService personaService;

	@RequestMapping(value="/showAllPersone", method = RequestMethod.GET)
	public String findAllPersone(HttpServletRequest request) {
        List<Persona> persone = (List<Persona>) this.personaService.findAll();
        request.getSession().setAttribute("persone", persone);
        return "showPersone";
    }
}