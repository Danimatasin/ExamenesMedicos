package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paciente_ID")
	private String paciente_ID;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="sexo")
	private String sexo;
	@Column(name="fecha_nacimiento")
	private String fecha_nacimiento;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente_ID", referencedColumnName="paciente_id")
	private List<Orden> orden;
	
	public Paciente() {

	}
	
	public Paciente(String paciente_ID, String nombre, String apellido, String sexo, String fecha_nacimiento) {
		super();
		this.paciente_ID = paciente_ID;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public List<Orden> getOrden() {
		return orden;
	}

	public void setOrden(List<Orden> orden) {
		this.orden = orden;
	}

	public String getPaciente_ID() {
		return paciente_ID;
	}

	public void setPaciente_ID(String paciente_ID) {
		this.paciente_ID = paciente_ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	
}
