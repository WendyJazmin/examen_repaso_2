package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Inventario;
import com.example.demo.repository.IInventarioRepository;

@Service
public class InventarioServiceImpl implements IInventarioService{

	@Autowired
	private IInventarioRepository iInventarioRepository;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.insertar(inventario);
	}

	@Override
	public Inventario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iInventarioRepository.buscar(id);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.actualizar(inventario);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.eliminar(id);
	}

	@Override
	public List<Inventario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iInventarioRepository.buscarTodos();
	}
	
	
}
