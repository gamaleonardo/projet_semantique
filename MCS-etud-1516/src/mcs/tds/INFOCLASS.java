package mcs.tds;

import java.util.ArrayList;
import java.util.HashMap;

import mcs.gc.Emplacement;
import mcs.type.*;


public class INFOCLASS implements INFO{
    protected HashMap<String,Methode> methodes;
 
    protected HashMap<String,DTYPEImpl> attributs;
    protected ArrayList<String> attribut;
    // classeMere;
    protected INFOCLASS classeMere;
    protected Emplacement empl;
    protected String nom;
    protected TDS tds;
    protected String access;
	@Override
	public DTYPE getType() {
		return null;
	}
	
	
    public HashMap<String,Methode> getMethodes(){
    	return methodes;
    }
  
    public INFOCLASS getClasseMere(){
    	return classeMere;
    }
    
    public HashMap<String,DTYPEImpl> getAttributs(){
    	HashMap<String,DTYPEImpl> res = attributs;
    	if(classeMere != null){
    		res.putAll(classeMere.getAttributs());
    	}
    	return res;
    }
    
    public INFOCLASS(TDS td,ArrayList<String> _attribut, Emplacement e, String Nom, INFOCLASS mere, String s ) {
		tds = td;
		attribut = _attribut;
		classeMere = mere;
		empl = e;
		nom = Nom;
		access =s;
	}
	
    
    
    
	public INFOCLASS(HashMap<String,Methode> m ,HashMap<String,DTYPEImpl> a, Emplacement e, String Nom) {
		methodes = m;
		attributs = a;
		classeMere = null;
		empl = e;
		nom = Nom;
	}
	
	public INFOCLASS(HashMap<String,Methode> m , HashMap<String,DTYPEImpl> a, INFOCLASS c, Emplacement e, String Nom) {
		methodes = m;
		attributs = a;
		classeMere = c;
		empl = e;
		nom = Nom;
	}
	
	public void setClasseMere (INFOCLASS c){
		classeMere = c;
	}
	
	@Override
	public String toString() {
		return "INFOCLASS [attributs=" + attributs + "]";
	}
	

	
	public String getNom(){
		return nom;
	}
	
	public Methode getMethode(String nom){
		Methode s = methodes.get(nom);
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

