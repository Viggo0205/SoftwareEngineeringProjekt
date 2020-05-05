// Skrevet af Eigil Sejer Larsen - s194282

import io.cucumber.java.en.Given;
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

	@Given("RegistrerTimer")
	public void addTid (int tid) {
		this.realTid += tid;
	}
	
	public void addMedarbejder (Medarbejder medarbejder) {
		this.medarbejdere.add(medarbejder);
	}
	
	public String getAllData() {
		String s = "\nAktivitets navn: " + this.navn + "\nstartuge: " + this.startDato.beregnUge() + "\nslutuge: " + this.slutDato.beregnUge() + "\nbudgettid: " + this.budgetTid + "\nrealtid: " + this.realTid + "\nmedarbejdere: ";
		for (Medarbejder m : medarbejdere)		
			s += m.getInitialer();
		return s;
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
	
	
	
}
