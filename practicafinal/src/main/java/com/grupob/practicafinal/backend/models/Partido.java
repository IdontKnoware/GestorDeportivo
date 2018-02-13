package com.grupob.practicafinal.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARTIDOS")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String jornada;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO_VISITANTE")
	private Equipo visitante;
	
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO_LOCAL")
	private Equipo local;
	
	private int golesLocal;
	private int golesVisitante;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	public Partido() {
	
	}

	public Partido(Integer id, String jornada, Equipo visitante, Equipo local, int golesLocal,
			int golesVisitante, Estado estado) {
		this.id = id;
		this.jornada = jornada;
		this.visitante = visitante;
		this.local = local;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.estado = estado;
	}

	// GETTERS/SETTERS + METODOS
	
	public Integer getId() {
		return id;
	}


	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Partido other = (Partido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", jornada=" + jornada + ", visitante=" + visitante + ", local=" + local
				+ ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + ", Estado=" + estado + "]";
	}

}
