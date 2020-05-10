// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class Kalender {
	private ArrayList<Arbejdsdag> arbejdsdage = new ArrayList<Arbejdsdag>();

	//Finder en arbejdsdags indeks i kallenderen ud fra dens dato
	public int findArbejdsagIndVedDato(Dato dag) {
		if (arbejdsdage.size() > 0)
		{
			for (Arbejdsdag a: this.arbejdsdage)
			{
				if ( dag.getFormatedDate().equalsIgnoreCase(a.getDag().getFormatedDate()) )
				{
					return this.arbejdsdage.indexOf(a);
				}
			}
			return -1;
		}
		else 
			return -1;
	}
	//Getters & adders
	public Arbejdsdag getCertainArbejdsdag(int i) {
		return this.arbejdsdage.get(i);
	}
	
	public int newDag(Dato dag) {
		this.arbejdsdage.add(new Arbejdsdag(dag));
		return findArbejdsagIndVedDato(dag);
	}

}
