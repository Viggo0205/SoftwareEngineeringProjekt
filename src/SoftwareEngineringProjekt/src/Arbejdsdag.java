// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;
import java.util.List;

public class Arbejdsdag {
	// Klassevariabler
	private Dato dag;
	private int halveTimerTotal;
	private List<String> projekter = new ArrayList<String>();
	private List<ArrayList<String>> aktiviteter = new ArrayList<ArrayList<String>>();
	private List<ArrayList<Integer>> aktivitetstider = new ArrayList<ArrayList<Integer>>();

	// Konstrukter
	public Arbejdsdag(Dato dato) {
		this.dag = dato;
		this.halveTimerTotal = 0;
	}

	// Tilføj eller erstat registreret tid til en aktivitet på givne dag
	public void addTid(String projekt, String aktivitet, int halveTimer) {
		int p = findProjInd(projekt);
		int a;
		if (p == -1)
			a = -1;
		else
			a = findAktInd(aktivitet, p);
		
		// Hvis der ikke allerede er registreret tid til projektet
		if (p == -1)
		{
			this.projekter.add(projekt);
			this.aktiviteter.add(new ArrayList<String>());
			this.aktiviteter.get(projekter.size() - 1).add(aktivitet);
			this.aktivitetstider.add(new ArrayList<Integer>());
			this.aktivitetstider.get(projekter.size() - 1).add(halveTimer);
			this.halveTimerTotal += halveTimer;
		}
		// Hvis der allerede er registreret tid til projektet, men ikke aktiviteten
		else if ( a == -1)
		{
			this.aktiviteter.get(p).add(aktivitet);
			this.aktivitetstider.get(p).add(halveTimer);
			this.halveTimerTotal += halveTimer;
		}
		// Hvis der allerede er registreret tid til aktiviteten
		else
		{
			this.halveTimerTotal -= this.aktivitetstider.get(p).get(a);
			this.aktivitetstider.get(p).set(a, halveTimer);
			this.halveTimerTotal += halveTimer;
		}
	}
	
	// Returnerer alle registrerede tider i en formateret streng.
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
	
	// Finder et projekts indeks i projekt-listen
	private int findProjInd(String projekt) {
		for (String p : projekter)
		{
			if (p.equals(projekt))
				return projekter.indexOf(p);
		}
		return -1;
	}
	
	// Finder en aktivitets indeks i projekt-listen
	private int findAktInd(String aktivitet, int p) {
		for (String a : aktiviteter.get(p))
		{
			if (a.equals(aktivitet))
				return aktiviteter.get(p).indexOf(a);
		}
		return -1;
	}
	
}
