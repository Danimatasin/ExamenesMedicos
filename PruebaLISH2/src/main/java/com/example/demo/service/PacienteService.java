package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Paciente;

public interface PacienteService {
	Paciente createPaciente(Paciente paciente);
	
	Paciente updatePaciente(Paciente paciente);
	
	List<Paciente> getAllPaciente();
	
	Paciente getPacienteById(String pacienteId);
	
	void deletePaciente(String id);
	
}
