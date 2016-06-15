package mcs.tds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * une TDS hiérarchique.
 * 
 * @author marcel
 * 
 */
public class TDS extends HashMap<String, INFO> {

	private static final long serialVersionUID = 1L;

	/**
	 * La TDS parente
	 */
	private TDS parente;

	private ArrayList<Namespace> listNs;

	/**
	 * Constructeur pour une TDS sans parente
	 */
	public TDS() {
		this(null);
	}

	/**
	 * Constructeur pour une TDS fille de p
	 * 
	 * @param p
	 */
	public TDS(TDS p) {
		super();
		parente = p;
		listNs = new ArrayList<Namespace>();
	}

	public TDS getParente() {
		return parente;
	}

	/**
	 * Recherche de n dans la TDS courante uniquement
	 * 
	 * @param n
	 * @return
	 */
	public INFO chercherLocalement(String n) {
		INFO i = get(n);
		if (i == null) {
			if (this.listNs != null) {
				Iterator<Namespace> it= this.listNs.iterator();
				while (it.hasNext() && i == null) {
					Namespace ns = it.next();
					if (ns.getActive()) {
						i = ns.getNstds().chercherLocalement(n);
					}
				}
			}
		}
		return i;
	}

	/**
	 * Recherche de n dans la TDS courante et ses parentes.
	 * 
	 * @param n
	 * @return
	 */
	public INFO chercherGlobalement(String n) {
		INFO i = chercherLocalement(n);
		if (i == null)
			if (parente != null)
				return parente.chercherGlobalement(n);
		return i;
	}

	/**
	 * Ajoute le nom n et son information i dans la TDS
	 * 
	 * @param n
	 * @param i
	 */
	public void inserer(String n, INFO i) {
		put(n, i);
	}

	public ArrayList<Namespace> getListNs() {
		return listNs;
	}
	public void insererNs(Namespace ns) {
		this.listNs.add(ns);
	}
	public Namespace chercherNs(String s){
		Namespace n = null;
		Iterator<Namespace> it= this.listNs.iterator();
		while (it.hasNext() && n == null) {
			if (it.next().getNom().equals(s)) {
				n = it.next();
			}
		}
		return n;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Set<Map.Entry<String, INFO>> s = entrySet();
		for (Map.Entry<String, INFO> e : s) {
			sb.append("; " + e.getKey() + " : " + e.getValue() + '\n');

		}
		return sb.toString();
	}


}
