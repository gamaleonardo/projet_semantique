package mcs.tds;
 
import java.util.ArrayList;

import mcs.gc.Emplacement;
import mcs.type.*;
import mcs.type.Parametres;

public class INFOFONC implements INFO {
	protected DtypeImpl typeRetour;
	protected Parametres params;
	protected Emplacement empl;
	
	public DtypeImpl getType() {
		return typeRetour;
	}

	public Emplacement getEmpl() {
		return empl;
	}

	public int getTaille() {
		return this.getType().getTaille();
	}

	public INFOFONC(DtypeImpl t, Emplacement e, Parametres p) {
		typeRetour = t;
		empl = e;
		params = p;
	}
	
	public Parametres getParams(){
		return params;
	}

	@Override
	public String toString() {
		return "INFOFONC [type=" + typeRetour.getNom() + ", empl=" + empl + "]";
	}

}
