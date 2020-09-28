package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	@Override
	public Paciente createPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public Paciente updatePaciente(Paciente paciente) {
		Optional<Paciente> pacienteDb = this.pacienteRepository.findById(paciente.getPaciente_ID());
		
		if(pacienteDb.isPresent()) {
			Paciente pacienteUpdate = pacienteDb.get();
			pacienteUpdate.setPaciente_ID(paciente.getPaciente_ID());
			pacienteUpdate.setNombre(paciente.getNombre());
			pacienteUpdate.setApellido(paciente.getApellido());
			pacienteUpdate.setSexo(paciente.getSexo());
			pacienteUpdate.setFecha_nacimiento(paciente.getFecha_nacimiento());
			pacienteRepository.save(pacienteUpdate);
			return pacienteUpdate;
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+paciente.getPaciente_ID());
		}
	}

	@Override
	public List<Paciente> getAllPaciente() {
		return this.pacienteRepository.findAll();
	}

	@Override
	public Paciente getPacienteById(String pacienteId) {
		
		Optional<Paciente> pacienteDb = this.pacienteRepository.findById(pacienteId);
		if(pacienteDb.isPresent()) {
			return pacienteDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+pacienteId);
		}
	}

	@Override
	public void deletePaciente(String pacienteId) {
		Optional<Paciente> pacienteDb = this.pacienteRepository.findById(pacienteId);
		if(pacienteDb.isPresent()) {
			this.pacienteRepository.delete(pacienteDb.get());
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+pacienteId);
		}
	}

}
