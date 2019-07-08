package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Persona;

@Repository
public interface PersoneRepository extends CrudRepository <Persona, Integer>{
	
}