package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscar(id);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iProductoRepository.eliminar(id);
	}

	@Override
	public Producto buscarPorCodigo(String Codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarPorCodigo(Codigo);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarTodos();
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public String eliminarSinRegistro(Integer id) {
		// TODO Auto-generated method stub
		Producto p = this.iProductoRepository.buscar(id);
		
		if(p.getStock()==0 || p.getStock()==null) {
			this.iProductoRepository.eliminar(p.getId());
			return "se elimino el producto";
		}else {
			return "no se puede eliminar el producto";
		}
	}
	
	
	
}
