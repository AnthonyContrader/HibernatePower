package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Studente extends Persona {
	
	@Column(name = "matricola")
	private int matricola;
	
}
