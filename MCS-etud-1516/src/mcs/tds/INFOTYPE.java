package mcs.tds;
import mcs.type.DTYPE;

public class INFOTYPE implements INFO {
	
	protected DTYPE type;
	

	// constructeur
	public INFOTYPE(DTYPE t) {
		type = t;
	}

	// affichage
	public String toString() {
		return "; ALIAS sur : " + "type=" + type ;
	}

	@Override
	public DTYPE getType() {
		return type;
	}

	
}
