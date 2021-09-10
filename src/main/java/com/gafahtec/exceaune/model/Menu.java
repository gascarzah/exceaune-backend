package com.gafahtec.exceaune.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

	@Id
	private Long menuId;

	@Column(name = "icono", length = 20)
	private String icono;

	@Column(name = "nombre", length = 20)
	private String nombre;

	@Column(name = "url", length = 50)
	private String url;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", 
	joinColumns = @JoinColumn(name = "menud_id", referencedColumnName = "menuId"),
	inverseJoinColumns = @JoinColumn(name="rol_id", referencedColumnName = "rolId"))
	private List<Rol> roles= new ArrayList<>();
	
}
