package com.gafahtec.exceaune.model;

import java.time.LocalDateTime;
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

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long articuloid;

	@Schema(description = "titulo del articulo")
	
	@Column(name = "titulo", nullable = false, length = 100)
	private String titulo;

	@Column(name = "contenido", nullable = false, length = 500)
	private String contenido;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;

	
	@Column(name = "orden", nullable = false)
	private Integer orden;
	
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	
	@ManyToOne
	@JoinColumn(name = "tipo_articulo_id", nullable = false, foreignKey = @ForeignKey(name = "Fk_tipo_articulo"))
	private TipoArticulo tipoArticulo;
	
	@ManyToOne
	@JoinColumn(name = "foto_id", foreignKey = @ForeignKey(name = "FK_articulo_foto"))
	private Foto foto;
	
	@ManyToOne
	@JoinColumn(name = "persona_id", foreignKey = @ForeignKey(name = "FK_articulo_persona"))
	private Persona persona;
	
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();

}
