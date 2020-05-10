// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.List;
import java.util.ArrayList;

public class Aktivitet {
	// Klassevariabler
	private List<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
	private String navn;
	private int budgetTid, realTid;
	private Dato startDato, slutDato;
	
	// Konstrukter
	public Aktivitet (String navn, Dato startUge, Dato slutUge, int budgetTid) {
		this.navn = navn;
		this.startDato = startUge;
		this.slutDato = slutUge;
		this.budgetTid = budgetTid;
		this.realTid = 0;
	}
	
	public void addTid (int tid) {
		this.realTid += tid;
	}
	
	// Tilføj medarbejder til aktiviteten
	public void addMedarbejder (Medarbejder medarbejder) {
		this.medarbejdere.add(medarbejder);
	}
	
	// Returnerer aktivitetens data formateret til 1 string
	public String getAllData() {
		String s = "Aktivitets navn: " + this.navn + "\nstartuge: " + this.startDato.beregnUge() + "-" + this.startDato.getYear() + "\nslutuge: " + this.slutDato.beregnUge() + "-" + this.slutDato.getYear() + "\nbudgettid: " + this.budgetTid + "\nrealtid: " + this.realTid + "\nmedarbejdere:";
		for (Medarbejder m : this.medarbejdere)
			s += "\n" + m.getInitialer();
		return s;
		}
	
	public String getNavn() {
		return this.navn;
	}
	
	public void setStartUge(int uge, int year) {
		this.startDato = new Dato(uge, year);
	}
	
	public int[] getStartUge() {
		return new int[]{this.startDato.beregnUge(), this.startDato.getYear()};
	}
	
	public int[] getSlutUge() {
		return new int[]{this.slutDato.beregnUge(), this.slutDato.getYear()};
	}
	
	public void setSlutUge(int uge, int year) {
		this.slutDato = new Dato(uge, year);
	}

	// Returnerer alle aktivitetens medarbejdere formateret til 1 string
	public String getMedarbejdereFormated() {
		String s = "Medarbejdere:";
		for (Medarbejder m : medarbejdere)
			s += "\n" + m.getInitialer();
		return s;
	}
	
	public ArrayList<Medarbejder> getMedarbejdere() {
		return (ArrayList<Medarbejder>) this.medarbejdere;
	}

	public int getTime() {
		return this.realTid;
	}
}
