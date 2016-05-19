package mcs.tds;
 
import java.util.ArrayList;

import mcs.gc.Emplacement;
import mcs.type.*;
import mcs.type.Parametres;

public class INFOFONC implements INFO {
	protected DTYPEImpl typeRetour;
	protected Parametres params;
	protected Emplacement empl;
	protected TDS ftds ; // la table de symbole associee au corps fe la fonction
	
	
	public DTYPEImpl getType() {
		return typeRetour;
	}

	public Emplacement getEmpl() {
		return empl;
	}

	public int getTaille() {
		return this.getType().getTaille();
	}

	public INFOFONC(DTYPEImpl t, Emplacement e, Parametres p, TDS tds) {
		typeRetour = t;
		empl = e;
		params = p;
		ftds = tds;
	}
	
	public Parametres getParams(){
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
