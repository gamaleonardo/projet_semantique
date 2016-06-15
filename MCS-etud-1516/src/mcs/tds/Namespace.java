package mcs.tds;

import java.util.ArrayList;

import mcs.type.DTYPE;

public class Namespace implements INFO {
    
    protected ArrayList<String> sousnamespace;
   	protected TDS nstds ;
   	protected String nom;
	
   	public Namespace(ArrayList<String> sousnamespace, TDS nstds, String nom) {
		super();
		this.sousnamespace = sousnamespace;
		this.nstds = nstds;
		this.nom = nom;
	}
   	
   	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Namespace(TDS nstds) {
		super();
		this.sousnamespace = null;
		this.nstds = nstds;
	}
	public TDS getNstds() {
		return nstds;
	}
   	
    public ArrayList<String> getSousnamespace() {
		return sousnamespace;
	}
    
	@Override
	public DTYPE getType() {
			return null;
	}
	
    	
 
}