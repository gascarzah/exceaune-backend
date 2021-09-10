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
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personaid;
	
	@ManyToOne
	@JoinColumn(name = "rango_id", nullable = false)
	private Rango rango;
	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;
	@Column(name = "apepaterno", nullable = false, length = 100)
	private String apepaterno;
	@Column(name = "apematerno", nullable = false, length = 100)
	private String apematerno;
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	@Column(name = "skype", nullable = false, length = 100)
	private String skype;
	@Column(name = "telefono", nullable = false, length = 100)
	private String telefono;
	@ManyToOne
	@JoinColumn(name = "foto_id")
	private Foto foto;
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "promocion_id", nullable = false, foreignKey = @ForeignKey(name = "FK_persona_promocion"))
	private Promocion promocion;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Articulo> articulos= new ArrayList<>();
}
