package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Orden;
import com.example.demo.repository.OrdenRepository;

@Service
@Transactional
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	private OrdenRepository ordenRepository;
	
	
	@Override
	public Orden createOrden(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Override
	public Orden updateOrden(Orden orden) {
		Optional<Orden> ordenDb = this.ordenRepository.findById(orden.getOrden_ID());
		
		if(ordenDb.isPresent()) {
			Orden ordenUpdate = ordenDb.get();
			ordenUpdate.setOrden_ID(orden.getOrden_ID());
			ordenUpdate.setTipo(orden.getTipo());
			ordenUpdate.setPaciente_id(orden.getPaciente_id());
			ordenUpdate.setFecha(orden.getFecha());
			ordenRepository.save(ordenUpdate);
			return ordenUpdate;
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+orden.getOrden_ID());
		}
	}

	@Override
	public List<Orden> getAllOrden() {
		return this.ordenRepository.findAll();
	}

	@Override
	public Orden getOrdenById(String ordenId) {
		
		Optional<Orden> ordenDb = this.ordenRepository.findById(ordenId);
		if(ordenDb.isPresent()) {
			return ordenDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+ordenId);
		}
	}

	@Override
	public void deleteOrden(String ordenId) {
		Optional<Orden> ordenDb = this.ordenRepository.findById(ordenId);
		if(ordenDb.isPresent()) {
			this.ordenRepository.delete(ordenDb.get());
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id: "+ordenId);
		}
	}

}
