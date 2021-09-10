package com.gafahtec.exceaune.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Rango {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rangoId;
	
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@OneToMany(mappedBy = "rango", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Promocion> promociones= new ArrayList<>();
}
