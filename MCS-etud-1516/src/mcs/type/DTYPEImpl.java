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

