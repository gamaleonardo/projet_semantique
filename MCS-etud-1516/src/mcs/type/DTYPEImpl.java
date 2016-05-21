package mcs.type;

public class DTYPEImpl implements DTYPE{
		protected int taille;

		public int getTaille() {
			return taille;
		}

		protected String nom;

		public String getNom() {
			return nom;
		}

		public DTYPEImpl(String n, int t) {
			nom = n;
			taille = t;
		}
		
		protected boolean affectable = false;
				
		public boolean getAffectable(){ //Leonardo
			return this.affectable;
		};
		
		//Leonardo
		/**	J'ai cree cette methode pour qu'on puisse savoir si le cote gauche d'une expression est une variable, alors que c'est la seule condition pour affecter
				Regardez regle INST -> #params E pv #r, ligne 558, dans MCS.egg
				Cette condition-là nous permettra de diferencier entre, par exemple :
					(1 + 2 + 5) = 8 * a; (syntatiquement valide, non semantiquement valide)
					et
					g = 1 + 2 * a / n; (syntatiquement et semantiquement valide)
		**/
		
		//Leonardo
		public DTYPEImpl(String n, int t, boolean affectation){
			nom = n;
			taille = t;
			this.affectable = affectation;
		}
		
		public boolean compareTo(DTYPE autre) {
			if ((autre.getNom()).equals("id")||autre.getNom().equals("null")){
			return true;
			}else {
				if (nom.equals("id")||nom.equals("null")) {return true;}
				else{
			        return nom.equals(autre.getNom());
				}
		    }
		}

		public String toString() {
			return nom + "(" + taille + ")";
		}
}

