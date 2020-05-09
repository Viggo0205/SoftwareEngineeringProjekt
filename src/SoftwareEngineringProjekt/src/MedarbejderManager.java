// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;
import java.util.List;

import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.InitialsWrongLengthException;

public class MedarbejderManager {
	private List<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
	private int nextMedarbejderID;
	
	public MedarbejderManager () {
		this.medarbejdere.add(new Medarbejder("ADMN", 0));
		this.nextMedarbejderID = 1;
	}
	
	public ArrayList<Medarbejder> getMedarbejdere() {
		return (ArrayList<Medarbejder>) this.medarbejdere;
	}
	
	public void newMedarbejder(String initialer) throws InitialsWrongLengthException, EmployeeAlreadyExistsException {
		System.out.println("Eigil told me to");
		if(initialer.length() != 4) {
			System.out.println("Eigil told me to1");
			throw new InitialsWrongLengthException();
			
		} else if (medarbExists(initialer)) {
			System.out.println("Eigil told me to2");
			throw new EmployeeAlreadyExistsException();
			
		} else {
			System.out.println("Eigil told me to3");
			this.medarbejdere.add(new Medarbejder(initialer, this.nextMedarbejderID));
			this.nextMedarbejderID += 1;
			
		}
	}

	private boolean medarbExists(String initialer) {
		for(Medarbejder q : medarbejdere){
			if(q.getInitialer().equals(initialer))
				return true;
		}
		return false;
	}
	
}
