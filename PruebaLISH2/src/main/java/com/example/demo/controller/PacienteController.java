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

import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/paciente")
	public ResponseEntity<List<Paciente>> getAllPaciente(){
		return ResponseEntity.ok().body(pacienteService.getAllPaciente());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/paciente/{id}")
	public ResponseEntity<Paciente> getPacienteById(@PathVariable String id){
		return ResponseEntity.ok().body(pacienteService.getPacienteById(id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/paciente")
	public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente){
		return ResponseEntity.ok().body(this.pacienteService.createPaciente(paciente));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/paciente/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable String id, @RequestBody Paciente paciente){
		paciente.setPaciente_ID(id);
		return ResponseEntity.ok().body(this.pacienteService.updatePaciente(paciente));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/paciente/{id}")
	public ResponseEntity<?> deletePaciente(@PathVariable String id){
		this.pacienteService.deletePaciente(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
	}
}
