package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Docente extends Persona {
	
	@Column(name = "email")
	private String email;
	

}
