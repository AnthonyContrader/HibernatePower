package it.contrader.model;

import it.contrader.model.Studente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table (name = "esami_sostenuti")
public class EsamiSostenuti {
	
	@Id
	@Column(name = "idEsame")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEsame;
	
	@Column(name = "voto")
	private int voto;
	
	@Column(name = "materia")
	private String materia;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="data")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Studente studente;

}