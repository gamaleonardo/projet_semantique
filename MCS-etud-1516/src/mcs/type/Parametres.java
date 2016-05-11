package mcs.type;

import java.util.ArrayList;
import java.util.HashMap;

public class Parametres {
	protected HashMap<String, DtypeImpl> table;
	protected ArrayList<DtypeImpl> types;

	public Parametres(){
		table = new HashMap<String, DtypeImpl>();
		types = new ArrayList<DtypeImpl>();
	}

	public Parametres(HashMap<String, DtypeImpl> t,ArrayList<DtypeImpl> tp){
		table = t;
		types = tp;
	}

	public DtypeImpl getParametre(String ident){
		return table.get(ident);
	}
	public ArrayList<DtypeImpl> getTypes(){
		return types;
	}

	public void ajouterType(DtypeImpl type){
		types.add(type);
	}

	public void ajouterParametre(String ident, DtypeImpl type){
		table.put(ident, type);
		types.add(type);
	}
}