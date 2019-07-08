package it.contrader.model;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "studente" )
public class Studente extends Persona {
	
	@Column(name = "matricola")
	private int matricola;
	
	// verso esami sostenuti
	@OneToMany(mappedBy="studente")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<EsamiSostenuti> esamiSostenuti;
	
	// verso corso
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "studente_corso", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "idCorso") })
	private Set<Corso> corsiUniv = new HashSet<>();
}