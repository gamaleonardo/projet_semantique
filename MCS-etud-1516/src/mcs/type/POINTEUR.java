package mcs.type;


public class POINTEUR extends DtypeImpl {
	private DtypeImpl type;


	public POINTEUR(DtypeImpl t) {
		super("pointeur", 1);
		type = t;

	}

	public DtypeImpl getType() {
		return type;
	}
	

	
	public boolean compareTo(DtypeImpl autre) {
		if ((autre.getNom()).equals("id")||(autre.getNom()).equals("null")){
			return true;
	    }else{
		if (autre instanceof POINTEUR)
			return type.compareTo(((POINTEUR) autre).type);
		return false;
	    }
	}


	public String toString(){
		return super.toString() + " sur type = " + type;
	}



}

