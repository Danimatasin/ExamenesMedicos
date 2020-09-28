package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Examen;

public interface ExamenService {
	Examen createExamen(Examen examen);
	
	Examen updateExamen(Examen examen);
	
	List<Examen> getAllExamen();
	
	Examen getExamenById(String examenId);
	
	void deleteExamen(String id);
	
}
