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
public class TipoArticulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipoArticuloId;
	
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@OneToMany(mappedBy = "tipoArticulo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Articulo> articulos= new ArrayList<>();
}
