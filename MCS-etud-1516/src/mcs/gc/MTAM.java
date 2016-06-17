package mcs.gc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import mcs.tds.INFOVAR;

/**
 * La machine TAM et ses fonctions de generation
 * @author marcel
 *
 */
public class MTAM extends AbstractMachine {

	@Override
	public String getSuffixe() {
		return "tam";
	}
	private String nom;

	public String genFonction(String etiquette, int taillepars,
			int tailleretour, String code) {
		return "_" + etiquette + ":\n" + code + "\tRETURN (" + taillepars + ") "
				+ tailleretour + "\n";

	}

	public String genCall(String etiquette) {
		return "; Appel a " + etiquette + "\n" + "\tCALL(SB) " + "_" + etiquette
				+ "\n";
	}

	// genere le code pour une declaration (avec initialisation)
	public String genDecl(String n, INFOVAR i, String t) {
		int taille = i.getType().getTaille();
		return "   ; declaration de " + n + " en " + i.getDep() + "/LB"
				+ " taille = " + taille + "\n" + t + "; fin de declaration de "
				+ n + "\n";
	}

	// compteur pour le generateur d'etiquettes
	private static int cpt = 0;

	// genere une etiquette differente des autres
	public String genEtiq() {
		return "X" + cpt++;
	}

	// genere le code pour l'arret de la machine
	public String genFin() {
		return "\tHALT\n";
	}

	public void genAsm(String nomf, String code) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(nom + ".tam"));
			pw.println(";;; code TAM engendre pour " + nom + "\n");
			pw.print(genCall(nomf));
			pw.print(genFin());
			pw.print(code);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String genCst(String v) {
		return "\tLOADL " + v + "\n";
	}

	public String genFree(int i) {
		// TODO Auto-generated method stub
		return "\tPOP(0)" + i + "\n";
	}

	public String genReadMem(int dep, int taille) {
		// TODO Auto-generated method stub
		return "\tLOAD(" + taille + ") " + dep + "[LB]\n";
	}
       
    	public String genReadMem(Emplacement e, int taille) {
		return "\tLOAD(" + taille + ") " + e.getDep() + "["+e.getReg().getName()+"]" + "\n";
	}

	public String genWriteMem(Emplacement e, int taille) {
		return "\tSTORE(" + taille + ") " + e.getDep() + "["+e.getReg().getName()+"]" + "\n";
	} 
     public String genAdr(Emplacement e) {
		return "\tLOADA " + e.getDep() + "["+e.getReg().getName()+"]" + "\n";
	}
     
	public String genReadIndirectMem(int taille) {
		// TODO Auto-generated method stub
		return "\tLOADI(" + taille + ")\n";
	}

	public String genWriteIndirectMem(int taille) {
		// TODO Auto-generated method stub
		return "\tSTOREI(" + taille + ")\n";
	}

	public String genIf(String code, String code2, String code3) {
		String sinon = genEtiq();
		String fin = genEtiq();
		return "\t; if\n" + code + "\n" + "\tJUMPIF(0) " + sinon  + "\n" + code2
				+ "\n" + "\tJUMP " + fin + "\n" + sinon + ":" + "\n" + code3 + "\n"
				+ fin + ":" + "\n" + "\t; fin if\n";
	}

	public String genMalloc(int taille) {
		return "\tLOADL " + taille + "\n" + "\tSUBR Malloc\n";
	}

	public String genAdrField(Emplacement e) {
		return "\t;Calcul deplacement struct " + e.getDep() + "\n" + "\tLOADL " + e.getDep()
				+ "\n\tSUBR Iadd\n";
	}

	public String genComment(String c) {
		return "; " + c + "\n";
	}
	
	public String genRetour(String c){
		return ""; //TODO 
	}
	
	public String genTv(ArrayList<String> tv){
		String res = "";
		
		for (int i=0 ; i<tv.size();i++){
			if (i==0){
				res = res  + "_" + tv.get(0)+ ":" + "\n";
			} else {
				res = res + "JUMP "  +"_"+tv.get(i) + "\n";
			
			}
		}
		
		
		return res;
	}
	
	public String genThis (ArrayList<String> attribut){
		
	return "LOADL " + attribut.size() + "\n" + "SUBR Malloc";
	
	}
}
