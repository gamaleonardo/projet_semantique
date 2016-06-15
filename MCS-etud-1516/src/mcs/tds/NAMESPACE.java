package mcs.tds;

import java.util.ArrayList;

import mcs.type.DTYPE;

public class NAMESPACE implements INFO {
    
    protected ArrayList<String> sousnamespace;
   	protected TDS nstds ;
   	protected String nom;
   	protected boolean active;
	
   	public NAMESPACE(ArrayList<String> sousnamespace, TDS nstds, String nom) {
		super();
		this.sousnamespace = sousnamespace;
		this.nstds = nstds;
		this.nom = nom;
	}
	public NAMESPACE(TDS nstds, String nom) {
		super();
		this.sousnamespace = null;
		this.nstds = nstds;
		this.nom = nom;
		this.active = false;
	}
	
	public void Active2true() {
		this.active = true;
	}
	public boolean getActive() {
		return this.active;
	}
   	
   	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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