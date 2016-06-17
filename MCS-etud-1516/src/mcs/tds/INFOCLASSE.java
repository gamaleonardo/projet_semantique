package mcs.tds;

import java.util.ArrayList;
import java.util.HashMap;

import mcs.gc.Emplacement;
import mcs.type.*;


public class INFOCLASSE implements INFO{
	protected HashMap<String,METHODE> methodes;
	 
    protected HashMap<String,DTYPEImpl> attributs;
    protected ArrayList<String> attribut;
    public ArrayList<String> getAttribut() {
		return attribut;
	}

	protected ArrayList<String> tv;
    public ArrayList<String> getTv() {
		return tv;
	}


	public void setTv(ArrayList<String> tv) {
		this.tv = tv;
	}

	// classeMere;
    protected INFOCLASSE classeMere;
    protected Emplacement empl;
    protected String nom;
    protected TDS tds;
    protected String access;
	@Override
	
	
	
	
	public DTYPE getType() {
		return new DTYPEImpl(this.getNom(),1);
	}
	
	
    public HashMap<String,METHODE> getMETHODEs(){
    	return methodes;
    }
  
    public INFOCLASSE getClasseMere(){
    	return classeMere;
    }
    
    public HashMap<String,DTYPEImpl> getAttributs(){
    	HashMap<String,DTYPEImpl> res = attributs;
    	if(classeMere != null){
    		res.putAll(classeMere.getAttributs());
    	}
    	return res;
    }
    
    public INFOCLASSE(TDS td,ArrayList<String> _attribut,ArrayList<String> _tv, Emplacement e, String Nom, INFOCLASSE mere, String s ) {
		tds = td;
		attribut = _attribut;
		classeMere = mere;
		empl = e;
		nom = Nom;
		access =s;
		tv=_tv;
	}
	
	
	public INFOCLASSE(HashMap<String,METHODE> m , HashMap<String,DTYPEImpl> a, INFOCLASSE c, Emplacement e, String Nom) {
		methodes = m;
		attributs = a;
		classeMere = c;
		empl = e;
		nom = Nom;
	}
	
	public void setClasseMere (INFOCLASSE c){
		classeMere = c;
	}
	
	@Override
	public String toString() {
		return "INFOCLASSE [attributs=" + attribut + "  table branchement " + tv;
	}
	

	
	public String getNom(){
		return nom;
	}
	
	public METHODE getMETHODE(String nom){
		METHODE s = methodes.get(nom);
		if (s==null && classeMere!=null){
			if(classeMere!=null){
				return classeMere.getMETHODE(nom);
			}
		}
		return s;
	}

	public boolean estMere(String s){
		if (nom.equals(s)){
			return true;
		}else{
			if (classeMere != null){
				return classeMere.estMere(s);
			}else{
				return false;
			}
		}
	}
}

