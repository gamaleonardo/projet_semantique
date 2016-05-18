package mcs.type;


public class POINTEUR extends DTYPEImpl {
	private DTYPEImpl type;


	public POINTEUR(DTYPEImpl t) {
		super("pointeur", 1);
		type = t;

	}

	public DTYPEImpl getType() {
		return type;
	}
	

	
	public boolean compareTo(DTYPEImpl autre) {
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

