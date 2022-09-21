package com.example.demo.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bodega")
public class Bodega {
	
	@Id
	@Column(name ="_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bode_id_seq")
	@SequenceGenerator(name="bode_id_seq", sequenceName = "bode_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="bode_nombre_bodega")
	private String nombreBodega;
	
	@Column(name ="bode_numero_bodega")
	private String numeroBodega;
	
	@Column(name ="bode_direccion")
	private String direccion;
	
	@Column(name ="bode_telefono")
	private String telefono;
	
	@ElementCollection
	private List<String> telefonos;
	
	@OneToMany(mappedBy="bodega", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Inventario> inventariosB;

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public String getNumeroBodega() {
		return numeroBodega;
	}

	public void setNumeroBodega(String numeroBodega) {
		this.numeroBodega = numeroBodega;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	public List<Inventario> getInventariosB() {
		return inventariosB;
	}

	public void setInventariosB(List<Inventario> inventariosB) {
		this.inventariosB = inventariosB;
	}
	
	

}
