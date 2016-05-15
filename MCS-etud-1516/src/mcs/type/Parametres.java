package mcs.type;

import java.util.ArrayList;
import java.util.HashMap;

public class Parametres {
	protected HashMap<String, DtypeImpl> table;
	protected ArrayList<String> ordreParam;

	public Parametres(){
		table = new HashMap<String, DtypeImpl>();
		ordreParam = new ArrayList<String>();
	}

	public Parametres(HashMap<String, DtypeImpl> t,ArrayList<String> op){
		table = t;
		ordreParam = op;
	}

	public DtypeImpl getParametre(String ident){
		return table.get(ident);
	}
	public ArrayList<String> getordreParam(){
		return ordreParam;
	}

	public void ajouterType(String ident){
		ordreParam.add(ident);
	}

	public void ajouterParametre(String ident, DtypeImpl type){
		table.put(ident, type);
		ordreParam.add(ident);
	}
}