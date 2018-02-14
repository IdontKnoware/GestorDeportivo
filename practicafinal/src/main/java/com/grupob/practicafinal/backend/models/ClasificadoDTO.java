package com.grupob.practicafinal.backend.models;

public class ClasificadoDTO {

	private Equipo equipo;
	
	private int PartidosGanados;
	private int PartidosEmpatados;
	private int PartidosPerdidos;
	
	private int GolesFavor;
	private int GolesContra;
	
	
	public ClasificadoDTO() {
		
	}


	public ClasificadoDTO(Equipo equipo, int partidosGanados, int partidosEmpatados, int partidosPerdidos,
			int golesFavor, int golesContra) {
		this.equipo = equipo;
		PartidosGanados = partidosGanados;
		PartidosEmpatados = partidosEmpatados;
		PartidosPerdidos = partidosPerdidos;
		GolesFavor = golesFavor;
		GolesContra = golesContra;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public int getPartidosGanados() {
		return PartidosGanados;
	}


	public void setPartidosGanados(int partidosGanados) {
		PartidosGanados = partidosGanados;
	}


	public int getPartidosEmpatados() {
		return PartidosEmpatados;
	}


	public void setPartidosEmpatados(int partidosEmpatados) {
		PartidosEmpatados = partidosEmpatados;
	}


	public int getPartidosPerdidos() {
		return PartidosPerdidos;
	}


	public void setPartidosPerdidos(int partidosPerdidos) {
		PartidosPerdidos = partidosPerdidos;
	}


	public int getGolesFavor() {
		return GolesFavor;
	}


	public void setGolesFavor(int golesFavor) {
		GolesFavor = golesFavor;
	}


	public int getGolesContra() {
		return GolesContra;
	}


	public void setGolesContra(int golesContra) {
		GolesContra = golesContra;
	}
	
	public int getPuntos() {
		return (PartidosGanados*3) + PartidosEmpatados;
	}

	@Override
	public String toString() {
		return "ClasificadoDTO [equipo=" + equipo + ", PartidosGanados=" + PartidosGanados + ", PartidosEmpatados="
				+ PartidosEmpatados + ", PartidosPerdidos=" + PartidosPerdidos + ", GolesFavor=" + GolesFavor
				+ ", GolesContra=" + GolesContra + "]";
	}
	
	
	
	
	
}
