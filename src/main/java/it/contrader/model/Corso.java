package it.contrader.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Corso")
public class Corso {

	@Id
	@Column(name = "idCorso")
	private Integer idCorso;
	
	@Column(name = "nome")
	private String nome;	
	
	// verso docente
	@OneToOne(mappedBy = "corsoUniv")
    private Docente esamiUniv;
	
	// verso studente
	@ManyToMany(mappedBy = "corsiUniv")
	private Set<Studente> studenti = new HashSet<>();	
}