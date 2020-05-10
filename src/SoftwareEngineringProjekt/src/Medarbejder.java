// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class Medarbejder {
	private String initialer;
	private int ID;
	private Kalender kalender;
	
	public Medarbejder(String initialer, int ID) {
		this.initialer = initialer;
		this.ID = ID;
		this.kalender = new Kalender();
	}
	
	public String getInitialer() {
		return this.initialer;
	}
	
	public Kalender getKalender() {
		return this.kalender;
	}
	
}
