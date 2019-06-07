package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "universita")
public class Universita {

	@Id
	@Column (name = "id")
	private Integer id;
	
	@Column (name = "nome")
	private String nome;
	
}
