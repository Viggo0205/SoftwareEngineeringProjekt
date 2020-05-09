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
		if(initialer.length() != 4) {
			throw new InitialsWrongLengthException();
			
		} else if (medarbExists(initialer)) {
			throw new EmployeeAlreadyExistsException();
			
		} else {
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
