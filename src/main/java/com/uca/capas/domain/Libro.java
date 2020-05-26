package com.uca.capas.domain;

//import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "c_libro")
	private Integer codigoLibro;
	
	@Size(message = "El campo no debe contener mas de 500 caracteres", max=500)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column (name = "s_titulo")
	private String titulo;
	
	@Size(message = "El campo no debe contener mas de 150 caracteres", max=150)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column (name = "s_autor")
	private String autor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	@Column (name = "f_ingreso")
	private Date fechaIngreso;
	
	@NotNull
	@Column (name = "b_estado", nullable=false)
	private Boolean estado;
	
	@Size(message = "El campo no debe contener mas de 10 caracteres", max=10)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column (name = "s_isbn")
	private String isbn;
	
	public Libro() {
		super();
	}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getEstadoDelegate() {
		if(this.estado==null) {
			return "";
		} else {
			return estado == true ? "Activo" : "Inactivo";
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getFechaIngresoDelegate() {
		if(this.fechaIngreso == null){
			return "";
		}
		else{
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fecha = sdf.format(this.fechaIngreso);
			return fecha;
		}
	}
}
