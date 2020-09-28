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

import com.example.demo.model.Orden;
import com.example.demo.service.OrdenService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenController {

	@Autowired
	private OrdenService ordenService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/orden")
	public ResponseEntity<List<Orden>> getAllOrden(){
		return ResponseEntity.ok().body(ordenService.getAllOrden());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/orden/{id}")
	public ResponseEntity<Orden> getOrdenById(@PathVariable String id){
		return ResponseEntity.ok().body(ordenService.getOrdenById(id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/orden")
	public ResponseEntity<Orden> createOrden(@RequestBody Orden orden){
		return ResponseEntity.ok().body(this.ordenService.createOrden(orden));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/orden/{id}")
	public ResponseEntity<Orden> updateOrden(@PathVariable String id, @RequestBody Orden orden){
		orden.setOrden_ID(id);
		return ResponseEntity.ok().body(this.ordenService.updateOrden(orden));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/orden/{id}")
	public ResponseEntity<?> deleteOrden(@PathVariable String id){
		this.ordenService.deleteOrden(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
	}
}
