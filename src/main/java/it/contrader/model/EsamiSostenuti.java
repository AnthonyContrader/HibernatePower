package it.contrader.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table (name = "esame")
public class Esame {
	
	@Id
	@Column(name = "idEsame")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEsame;
	
	@Column(name = "voto")
	private int voto;
	
	@Column(name = "materiale")
	private String materiale;
	
	@ManyToMany(mappedBy = "esami")
	private List<Studente> studenti = new ArrayList<>();
	
	
	
	

}
