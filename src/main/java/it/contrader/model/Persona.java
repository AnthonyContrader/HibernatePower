package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Entity
//@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "indirizzo")
	private String indirizzo;
}