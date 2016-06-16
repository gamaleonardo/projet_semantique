package mcs.tds;

import java.util.ArrayList;
import java.util.HashMap;

import mcs.gc.Emplacement;
import mcs.type.*;


public class INFOCLASSE implements INFO{
    protected HashMap<String,METHODE> methodes;
 
    protected HashMap<String,DTYPEImpl> attributs;
    // classeMere;
    protected INFOCLASSE classeMere;
    protected Emplacement empl;
    protected String nom;
    

	@Override
	public DTYPE getType() {
		return null;
	}
	
	
    public HashMap<String,METHODE> getMethodes(){
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
    
	public INFOCLASSE(HashMap<String,METHODE> m ,HashMap<String,DTYPEImpl> a, Emplacement e, String Nom) {
		methodes = m;
		attributs = a;
		classeMere = null;
		empl = e;
		nom = Nom;
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
		return "INFOCLASSE [attributs=" + attributs + "]";
	}
	

	
	public String getNom(){
		return nom;
	}
	
	public METHODE getMethode(String nom){
		METHODE s = methodes.get(nom);
		if (s==null && classeMere!=null){
			if(classeMere!=null){
				return classeMere.getMethode(nom);
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

