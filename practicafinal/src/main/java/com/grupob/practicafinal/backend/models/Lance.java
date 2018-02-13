package com.grupob.practicafinal.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LANCES")
public class Lance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private int idPartido;
	private int idEquipo;
	private int minuto;
	private TiposLance tipos;
	private String comentario;
	
	// CONSTRUCTORES
	
	public Lance() {}
	public Lance(Integer id, int idPartido, int idEquipo, int minuto, TiposLance tipos, String comentario) {
		super();
		this.id = id;
		this.idPartido = idPartido;
		this.idEquipo = idEquipo;
		this.minuto = minuto;
		this.tipos = tipos;
		this.comentario = comentario;
	}
	
	// GETTERS/SETTERS + METODOS
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public TiposLance getTipos() {
		return tipos;
	}
	public void setTipos(TiposLance tipos) {
		this.tipos = tipos;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lance other = (Lance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
