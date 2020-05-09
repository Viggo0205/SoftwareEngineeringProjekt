// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class Arbejdsdag {
	private Dato dag;
	private int halveTimerTotal;
	private ArrayList<String> projekter = new ArrayList<String>();
	private ArrayList<ArrayList<String>> aktiviteter = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<Integer>> aktivitetstider = new ArrayList<ArrayList<Integer>>();

	public Arbejdsdag(Dato dato) {
		this.dag = dato;
		this.halveTimerTotal = 0;
	}

	public void addTid(String projekt, String aktivitet, int halveTimer) {
		int p = findProjInd(projekt);
		int a;
		if (p == -1)
			a = -1;
		else
			a = findAktInd(aktivitet, p);
		
		if (p == -1)
		{
			this.projekter.add(projekt);
			this.aktiviteter.add(new ArrayList<String>());
			this.aktiviteter.get(projekter.size() - 1).add(aktivitet);
			this.aktivitetstider.add(new ArrayList<Integer>());
			this.aktivitetstider.get(projekter.size() - 1).add(halveTimer);
			this.halveTimerTotal += halveTimer;
		}
		else if ( a == -1)
		{
			this.aktiviteter.get(p).add(aktivitet);
			this.aktivitetstider.get(p).add(halveTimer);
			this.halveTimerTotal += halveTimer;
		}
		else
		{
			this.halveTimerTotal -= this.aktivitetstider.get(p).get(a);
			this.aktivitetstider.get(p).set(a, halveTimer);
			this.halveTimerTotal += halveTimer;
		}
	}
	
	public String getTid() {
		String s = "Arbejdstider for: " + dag.getFormatedDate() + "\n";
		for (String p : projekter)
		{
			s += p + "\n";
			for (String a : aktiviteter.get(findProjInd(p)))
			{
				s += a + ": " + aktivitetstider.get(findProjInd(p)).get(findAktInd(a, findProjInd(p))) + "\n";
			}
		}
		s += "Totaltid: " + halveTimerTotal;
		return s;
	}
	
	private int findProjInd(String projekt) {
		for (String p : projekter)
		{
			if (p.equals(projekt))
				return projekter.indexOf(p);
		}
		return -1;
	}
	
	private int findAktInd(String aktivitet, int p) {
		for (String a : aktiviteter.get(p))
		{
			if (a.equals(aktivitet))
				return aktiviteter.get(p).indexOf(a);
		}
		return -1;
	}
	
}
