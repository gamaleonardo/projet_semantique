package mcs.tds;

import mcs.type.DTYPE;

public class NAMESPACE implements INFO {
    
   	protected TDS nstds ;
   	protected String nom;
   	protected boolean active;
	
	public NAMESPACE(TDS nstds, String nom) {
		super();
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
    
	@Override
	public DTYPE getType() {
			return null;
	}
	
    	
 
}