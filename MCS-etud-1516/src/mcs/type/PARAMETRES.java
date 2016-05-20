package mcs.type;

import java.util.ArrayList;
import java.util.HashMap;

import mcs.tds.INFOVAR;

public class PARAMETRES {
	protected HashMap<String, INFOVAR> table;
	protected ArrayList<String> ordreParam;

	public PARAMETRES(){
		table = new HashMap<String, INFOVAR>();
		ordreParam = new ArrayList<String>();
	}

	public PARAMETRES(HashMap<String, INFOVAR> t,ArrayList<String> op){
		table = t;
		ordreParam = op;
	}

	public INFOVAR getParametre(String ident){
		return table.get(ident);
	}
	public ArrayList<String> getordreParam(){
		return ordreParam;
	}

	public void ajouterType(String ident){
		ordreParam.add(ident);
	}

	public void ajouterParametre(String ident, INFOVAR iv){
		table.put(ident, iv);
		ordreParam.add(ident);
	}
}