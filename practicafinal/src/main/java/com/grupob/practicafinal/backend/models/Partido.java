package com.grupob.practicafinal.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTIDOS")
public class Partido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String jornada;
	private Integer idEquipoVisitante;
	private Integer idEquipoLocal;
	private int golesLocal;
	private int golesVisitante;
	private Estado idEstado;

	// CONSTRUCTORES

	public Partido() {
	}

	public Partido(Integer id, String jornada, Integer idEquipoVisitante, Integer idEquipoLocal, int golesLocal,
			int golesVisitante, Estado idEstado) {
		super();
		this.id = id;
		this.jornada = jornada;
		this.idEquipoVisitante = idEquipoVisitante;
		this.idEquipoLocal = idEquipoLocal;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.idEstado = idEstado;
	}

	// GETTERS/SETTERS + METODOS

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public Integer getIdEquipoVisitante() {
		return idEquipoVisitante;
	}

	public void setIdEquipoVisitante(Integer idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}

	public Integer getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public void setIdEquipoLocal(Integer idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
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

	public Estado getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
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
		return "Partido [id=" + id + ", jornada=" + jornada + ", idEquipoVisitante=" + idEquipoVisitante
				+ ", idEquipoLocal=" + idEquipoLocal + ", golesLocal=" + golesLocal + ", golesVisitante="
				+ golesVisitante + ", idEstado=" + idEstado + "]\n";
	}

}
