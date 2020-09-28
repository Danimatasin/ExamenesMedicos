package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Examen;
import com.example.demo.repository.ExamenRepository;

@Service
@Transactional
public class ExamenServiceImpl implements ExamenService{

	@Autowired
	private ExamenRepository examenRepository;
	
	
	@Override
	public Examen createExamen(Examen examen) {
		return examenRepository.save(examen);
	}

	@Override
	public Examen updateExamen(Examen examen) {
		Optional<Examen> examenDb = this.examenRepository.findById(examen.getExamen_id());
		
		if(examenDb.isPresent()) {
			Examen examenUpdate = examenDb.get();
			examenUpdate.setExamen_id(examen.getExamen_id());
			examenUpdate.setOrden_id(examen.getOrden_id());
			examenUpdate.setNombre(examen.getNombre());
			examenRepository.save(examenUpdate);
			return examenUpdate;
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+examen.getExamen_id());
		}
	}

	@Override
	public List<Examen> getAllExamen() {
		return this.examenRepository.findAll();
	}

	@Override
	public Examen getExamenById(String examenId) {
		
		Optional<Examen> examenDb = this.examenRepository.findById(examenId);
		if(examenDb.isPresent()) {
			return examenDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+examenId);
		}
	}

	@Override
	public void deleteExamen(String examenId) {
		Optional<Examen> examenDb = this.examenRepository.findById(examenId);
		if(examenDb.isPresent()) {
			this.examenRepository.delete(examenDb.get());
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+examenId);
		}
	}

}
