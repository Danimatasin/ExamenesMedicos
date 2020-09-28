package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examen")
public class Examen {
	@Id
	@Column(name="examen_id")
	private String examen_id;
	@Column(name="nombre")
	private String nombre;
    @Column(name ="orden_id")
	private String orden_id;
	
	
	
	
	public Examen() {

	}

	public Examen(String examen_id, String nombre, String orden_id) {
		super();
		this.examen_id = examen_id;
		this.nombre = nombre;
		this.orden_id = orden_id;
	}

	public String getExamen_id() {
		return examen_id;
	}


	public void setExamen_id(String examen_id) {
		this.examen_id = examen_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getOrden_id() {
		return orden_id;
	}


	public void setOrden_id(String orden_id) {
		this.orden_id = orden_id;
	}
	
	
}
