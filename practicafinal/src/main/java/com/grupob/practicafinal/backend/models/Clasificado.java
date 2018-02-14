package com.grupob.practicafinal.backend.models;

public class Clasificado {
	
	private Equipo equipo;
	
	// Como LOCAL
	
	private int PGL;
	private int PEL;
	private int PPL;
	
	private int GFL;
	private int GCL;
	
	// Como VISITANTE
	
	private int PGV;
	private int PEV;
	private int PPV;
		
	private int GFV;
	private int GCV;
	
	public Clasificado() {
		
	}

	public Clasificado(Equipo equipo, int pGL, int pEL, int pPL, int gFL, int gCL, int pGV, int pEV, int pPV, int gFV,
			int gCV) {
		this.equipo = equipo;
		PGL = pGL;
		PEL = pEL;
		PPL = pPL;
		GFL = gFL;
		GCL = gCL;
		PGV = pGV;
		PEV = pEV;
		PPV = pPV;
		GFV = gFV;
		GCV = gCV;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPGL() {
		return PGL;
	}

	public void setPGL(int pGL) {
		PGL = pGL;
	}

	public int getPEL() {
		return PEL;
	}

	public void setPEL(int pEL) {
		PEL = pEL;
	}

	public int getPPL() {
		return PPL;
	}

	public void setPPL(int pPL) {
		PPL = pPL;
	}

	public int getGFL() {
		return GFL;
	}

	public void setGFL(int gFL) {
		GFL = gFL;
	}

	public int getGCL() {
		return GCL;
	}

	public void setGCL(int gCL) {
		GCL = gCL;
	}

	public int getPGV() {
		return PGV;
	}

	public void setPGV(int pGV) {
		PGV = pGV;
	}

	public int getPEV() {
		return PEV;
	}

	public void setPEV(int pEV) {
		PEV = pEV;
	}

	public int getPPV() {
		return PPV;
	}

	public void setPPV(int pPV) {
		PPV = pPV;
	}

	public int getGFV() {
		return GFV;
	}

	public void setGFV(int gFV) {
		GFV = gFV;
	}

	public int getGCV() {
		return GCV;
	}

	public void setGCV(int gCV) {
		GCV = gCV;
	}
	
	public int getPuntosLocal() {
		return (PGL * 3) + PEL;
	}
	
	public int getPuntosVisitante() {
		return (PGV * 3) + PEV;
	}
	
	public int getPGG() {
		return PGL + PGV;
	}
	
	public int getPEG() {
		return PEL + PEV;
	}
	
	public int getPPG() {
		return PPL + PPV;
	}
	
	public int getGFG() {
		return GFL + GFV;
	}
	
	public int getGCG() {
		return GCL + GCV;
	}
	
	public int getPuntosGeneral() {
		return getPuntosLocal() + getPuntosVisitante();
	}

	@Override
	public String toString() {
		return "Clasificado [equipo=" + equipo + ", PGL=" + PGL + ", PEL=" + PEL + ", PPL=" + PPL + ", GFL=" + GFL
				+ ", GCL=" + GCL + ", PGV=" + PGV + ", PEV=" + PEV + ", PPV=" + PPV + ", GFV=" + GFV + ", GCV=" + GCV
				+ "]";
	}
	
}
