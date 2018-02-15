package com.grupob.practicafinal.backend.models;

public enum TipoLance {
	
	AGRESION, CORNER, FALTA, FALTA_PELIGROSA, GOL, INCIDENCIA, JUGADA, 
	LESION, OCASION, PENALTY, TARJETA_AMARILLA, TARJETA_ROJA;
	
	public String getString() {
        return this.name();
    }

}
