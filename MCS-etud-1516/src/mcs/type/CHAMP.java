package mcs.type;

import mcs.gc.Emplacement;

public class CHAMP {
	private String nom;
	private Emplacement empl;
	private DTYPE type;

	public String getNom() {
		return nom;
	}

	public DTYPE getType() {
		return type;
	}

	public int getDep() {
		return empl.getDep();
	}
	public Emplacement getEmpl() {
		return empl;
	}

	public CHAMP(String nom, DTYPE type, Emplacement empl) {
		super();
		this.nom = nom;
		this.type = type;
		this.empl = empl;
	}

	public String toString() {
		return nom + ": " + type + " dep = " + empl.getDep();
	}

}
