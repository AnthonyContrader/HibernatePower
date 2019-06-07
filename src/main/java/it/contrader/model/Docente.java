package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "docente")
public class Docente extends Persona {
	
	@Column(name = "email")
	private String email;
	

}
 