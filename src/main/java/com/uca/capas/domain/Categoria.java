package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (schema="public", name="cat_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "c_categoria")
	private Integer cCategoria;
	
	@Size(message = "El campo no debe contener mas de 50 caracteres", max=50)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column (name = "s_categoria")
	private String sCategoria;
	
	//@OneToMany(mappedBy="cat_categoria", fetch=FetchType.EAGER)
	//private List<Libro> libros;
	
	public Categoria() {
		super();
	}

	public Integer getcCategoria() {
		return cCategoria;
	}

	public void setcCategoria(Integer cCategoria) {
		this.cCategoria = cCategoria;
	}

	public String getsCategoria() {
		return sCategoria;
	}

	public void setsCategoria(String sCategoria) {
		this.sCategoria = sCategoria;
	}
	/*
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	*/
	
}
