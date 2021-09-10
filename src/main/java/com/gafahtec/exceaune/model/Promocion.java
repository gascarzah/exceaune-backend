package com.gafahtec.exceaune.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long promocionId;
	
	@Column(name = "anio", nullable = false, length = 100)
	private Integer anio;
	
	@Column(name = "seccion", nullable = false, length = 100)
	private String seccion;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "activo", nullable = false)
	private Boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "foto_id" , foreignKey = @ForeignKey(name = "FK_promocion_foto"))
	private Foto foto;
	
	@ManyToOne
	@JoinColumn(name = "rango_id" , foreignKey = @ForeignKey(name = "FK_promocion_rango"))
	private Rango rango;
	

	
	@OneToMany(mappedBy = "promocion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Persona> personas= new ArrayList<>();
	
}
