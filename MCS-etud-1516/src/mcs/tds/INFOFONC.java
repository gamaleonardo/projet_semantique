package mcs.tds;
 
import java.util.ArrayList;

import mcs.gc.Emplacement;
import mcs.type.*;
import mcs.type.PARAMETRES;

public class INFOFONC implements INFO {
	protected DTYPE typeRetour;
	protected PARAMETRES params;
	protected Emplacement empl;
	protected TDS ftds ; // la table de symbole associee au corps de la fonction
	
	
	public DTYPE getType() {
		return typeRetour;
	}

	public Emplacement getEmpl() {
		return empl;
	}

	public int getTaille() {
		return this.getType().getTaille();
	}

	public INFOFONC(DTYPE t, Emplacement e, PARAMETRES p) {
		typeRetour = t;
		empl = e;
		params = p;
		ftds = tds;
	}
	
	public PARAMETRES getParams(){
		return params;
	}

	@Override
	public String toString() {
		return "INFOFONC [type=" + typeRetour.getNom() + ", empl=" + empl + "]";
	}
	public TDS getTDS(){
		return ftds;
	}
}
