package mcs.tds;

import java.util.ArrayList;

import mcs.type.DTYPE;

public class Namespace implements INFO {
    
    protected ArrayList<Namespace> sousnamespace;
   	protected TDS nstds ;
	
   	public Namespace(ArrayList<Namespace> sousnamespace, TDS nstds) {
		super();
		this.sousnamespace = sousnamespace;
		this.nstds = nstds;
	}

	public TDS getNstds() {
		return nstds;
	}
   	
    public ArrayList<Namespace> getSousnamespace() {
		return sousnamespace;
	}
    
	@Override
	public DTYPE getType() {
			return null;
	}
	
    	
 
}