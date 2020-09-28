package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@Column(name="orden_id")
	private String orden_ID;
	@Column(name="tipo")
	private String tipo;
	@Column(name="paciente_id")
	private String paciente_id;
	@Column(name="fecha")
	private String fecha;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orden_id", referencedColumnName="orden_id")
	private List<Examen> examen;
	
	public Orden() {

	}

	public Orden(String orden_ID, String tipo, String paciente_id, String fecha) {
		super();
		this.orden_ID = orden_ID;
		this.tipo = tipo;
		this.paciente_id = paciente_id;
		this.fecha = fecha;
	}

	public List<Examen> getExamen() {
		return examen;
	}

	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}

	public String getOrden_ID() {
		return orden_ID;
	}

	public void setOrden_ID(String orden_ID) {
		this.orden_ID = orden_ID;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(String paciente_id) {
		this.paciente_id = paciente_id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
	
}
