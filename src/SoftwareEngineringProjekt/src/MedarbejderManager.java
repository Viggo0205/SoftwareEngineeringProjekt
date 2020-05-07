// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class MedarbejderManager {
	private ArrayList<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
	private int nextMedarbejderID;
	
	MedarbejderManager () {
		this.medarbejdere.add(new Medarbejder("ADM", 0));
		this.nextMedarbejderID = 1;
	}
	
	public ArrayList<Medarbejder> getMedarbejdere() {
		return this.medarbejdere;
	}
	
	public void newMedarbejder(String initialer) {
		this.medarbejdere.add(new Medarbejder(initialer, this.nextMedarbejderID));
		this.nextMedarbejderID += 1;
	}
}
