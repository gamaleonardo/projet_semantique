package mcs.type;

import java.util.ArrayList;
import java.util.HashMap;

public class PARAMETRES {
	protected HashMap<String, DTYPEImpl> table;
	protected ArrayList<String> ordreParam;

	public PARAMETRES(){
		table = new HashMap<String, DTYPEImpl>();
		ordreParam = new ArrayList<String>();
	}

	public PARAMETRES(HashMap<String, DTYPEImpl> t,ArrayList<String> op){
		table = t;
		ordreParam = op;
	}

	public DTYPEImpl getParametre(String ident){
		return table.get(ident);
	}
	public ArrayList<String> getordreParam(){
		return ordreParam;
	}

	public void ajouterType(String ident){
		ordreParam.add(ident);
	}

	public void ajouterParametre(String ident, DTYPEImpl type){
		table.put(ident, type);
		ordreParam.add(ident);
	}
}