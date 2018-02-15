package com.grupob.practicafinal.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LANCES")
public class Lance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_PARTIDO")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO")
	private Equipo equipo;
	
	private int minuto;
	
	@Enumerated(EnumType.STRING)
	@Column ( name = "id_tipo")
	private TipoLance tipos;
	
	private String comentario;
	
	public Lance() {
		
	}	
	
	public Lance(Partido partido, Equipo equipo, int minuto, TipoLance tipos, String comentario) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.minuto = minuto;
		this.tipos = tipos;
		this.comentario = comentario;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public TipoLance getTipos() {
		return tipos;
	}
	public void setTipos(TipoLance tipos) {
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

	@Override
	public String toString() {
		return "Lance [id=" + id + ", partido=" + partido + ", equipo=" + equipo + ", minuto=" + minuto + ", tipos="
				+ tipos + ", comentario=" + comentario + "]";
	}
}
