package com.example.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.IBodegaRepository;
import com.example.demo.repository.IProductoRepository;

@Service
public class GestorInventarioServiceImpl implements IGestorInventarioService{

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IBodegaRepository iBodegaRepository;
	
	@Autowired
	private IInventarioService IInventarioService;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void ingresarInventario(String numeroBodega, String codigoBarras, Integer cantidad) {
		// TODO Auto-generated method stub
		Producto producto = this.productoRepository.buscarPorCodigo(codigoBarras);
		Bodega bodega = this.iBodegaRepository.buscarporNumero(numeroBodega);
		
		producto.setStock(cantidad);
		this.productoRepository.actualizar(producto);
		Inventario inv = new Inventario();
		
		for(int i=1; i<=cantidad;i++) {
			inv.setNombreHilo("hilo"+i);
			inv.setCodigoBarrasIndividual(codigoBarras+i);
			inv.setBodega(bodega);
			inv.setProducto(producto);
			this.IInventarioService.insertar(inv);
		}
	
	}

}
