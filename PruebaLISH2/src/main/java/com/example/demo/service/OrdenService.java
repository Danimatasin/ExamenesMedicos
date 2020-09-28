package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Orden;

public interface OrdenService {
	Orden createOrden(Orden orden);
	
	Orden updateOrden(Orden orden);
	
	List<Orden> getAllOrden();
	
	Orden getOrdenById(String ordenId);
	
	void deleteOrden(String id);
	
}
