package mcs.tds;
import mcs.type.*;
import mcs.gc.*;

public class METHODE implements INFO{
	protected DTYPEImpl typeRetour;
	protected PARAMETRES params;
	protected Emplacement empl;
	protected String nom;
	
	public String getNom(){
		return nom;
	}

	public DTYPEImpl getType() {
		return typeRetour;
	}

	public Emplacement getEmpl() {
		return empl;
	}

	public int getTaille() {
		return this.getTaille();
	}

	
	public METHODE(DTYPEImpl t, Emplacement e, PARAMETRES p, String s) {
		typeRetour = t;
		empl = e;
		params = p;
		nom=s;
	}
	
	public PARAMETRES getParams(){
		return params;
	}

	@Override
	public String toString() {
		return "INFO [type=" + typeRetour.getNom() + ", empl=" + empl + "]";
	}

}