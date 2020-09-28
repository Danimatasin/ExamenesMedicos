package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExamenController {

	@Autowired
	private ExamenService examenService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/examen")
	public ResponseEntity<List<Examen>> getAllExamen(){
		return ResponseEntity.ok().body(examenService.getAllExamen());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/examen/{id}")
	public ResponseEntity<Examen> getExamenById(@PathVariable String id){
		return ResponseEntity.ok().body(examenService.getExamenById(id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/examen")
	public ResponseEntity<Examen> createExamen(@RequestBody Examen examen){
		return ResponseEntity.ok().body(this.examenService.createExamen(examen));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/examen/{id}")
	public ResponseEntity<Examen> updateExamen(@PathVariable String id, @RequestBody Examen examen){
		examen.setExamen_id(id);
		return ResponseEntity.ok().body(this.examenService.updateExamen(examen));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/examen/{id}")
	public ResponseEntity<?> deleteExamen(@PathVariable String id){
		this.examenService.deleteExamen(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
	}
}
