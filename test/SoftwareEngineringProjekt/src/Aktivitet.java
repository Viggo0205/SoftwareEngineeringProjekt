// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class Aktivitet {
	private ArrayList<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
	private String navn;
	private int budgetTid, realTid;
	private Dato startDato, slutDato;
	
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
	
	public void addMedarbejder (Medarbejder medarbejder) {
		this.medarbejdere.add(medarbejder);
	}
	
	public String getMedarbejdere () {
		String s = "Medarbejdere:";
		for (Medarbejder m : medarbejdere)
			s += "\n" + m.getInitialer();
		return s;
	}
	
	public String getAllData() {
		return "\nAktivitets navn: " + this.navn + "\nstartuge: " + this.startDato.beregnUge() + "\nslutuge: " + this.slutDato.beregnUge() + "\nbudgettid: " + this.budgetTid + "\nrealtid: " + this.realTid + "\nmedarbejdere: " + this.medarbejdere.get(0).getInitialer();
	}
	
	public String getNavn() {
		return this.navn;
	}
	
	public void setStartUge(int uge, int year) {
		this.startDato = new Dato(uge, year);
	}
	
	public int[] getStartUge() {
		return new int[]{this.startDato.beregnUge(), this.slutDato.getYear()};
	}
	
	public int[] getSlutUge() {
		return new int[]{this.slutDato.beregnUge(), this.slutDato.getYear()};
	}
	
	public void setSlutUge(int uge, int year) {
		this.slutDato = new Dato(uge, year);
	}

	public int getTime() {
		// TODO Auto-generated method stub
		return this.realTid;
	}
	
}
