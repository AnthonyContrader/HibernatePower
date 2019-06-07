package it.contrader.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "studente" )
public class Studente extends Persona {
	
	@Column(name = "matricola")
	private int matricola;
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	@JoinTable(name = "studente_esame",
    	joinColumns = @JoinColumn(name = "id"),
    	inverseJoinColumns = @JoinColumn(name = "idEsame")
	)
	private List<Esame> esami = new ArrayList<>();
	
	
	
	
}
