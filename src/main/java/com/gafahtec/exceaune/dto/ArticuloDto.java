package com.gafahtec.exceaune.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticuloDto {

	private Long articuloid;
	private String titulo;
	private String contenido;
	private LocalDateTime fecha;
	private Integer orden;
	private Boolean activo;
}
