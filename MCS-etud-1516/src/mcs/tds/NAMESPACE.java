package mcs.tds;

import java.util.ArrayList;

import mcs.type.DTYPE;

public class NAMESPACE implements INFO {
    
    protected ArrayList<NAMESPACE> sousnamespace;
   	protected TDS nstds ;
	
   	public NAMESPACE(ArrayList<NAMESPACE> sousnamespace, TDS nstds) {
		super();
		this.sousnamespace = sousnamespace;
		this.nstds = nstds;
	}

	public TDS getNstds() {
		return nstds;
	}
   	
    public ArrayList<NAMESPACE> getSousnamespace() {
		return sousnamespace;
	}
    
	@Override
	public DTYPE getType() {
			return null;
	}
	
    	
 
}