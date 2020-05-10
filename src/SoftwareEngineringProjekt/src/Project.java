// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.awt.*;
import java.util.ArrayList;
import java.io.Serializable;

/*
	Behandl lovlige uger client-side
	Giv kun setters til leder, behandles client-side
	Start- og slut-uger er egentligt datoer, men kan blot returneres som med .beregnUge()
*/

public class Project {
	private ArrayList<Aktivitet> aktiviteter = new ArrayList<Aktivitet>();
	private ArrayList<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
	private Medarbejder projektleder;
	private Dato startDato, slutDato;
	private String navn, projektNummer;
	
	// Konstruktor
	public Project(String navn, Medarbejder projektleder, Dato startDato, Dato slutDato, String projektNummer) {
		this.navn = navn;
		this.projektleder = projektleder;
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.projektNummer = projektNummer;
		addMedarbejder(projektleder);
	}
	
	//Finder en aktivitets indeks i projektets aktivitetsliste ved aktivitetens navn
	public int findAktVedNavn(String navn) {
		for (Aktivitet a : this.aktiviteter)
		{
			if (a.getNavn().equalsIgnoreCase(navn))
				return this.aktiviteter.indexOf(a);
		}
		return -1;
	}
	
	// Getters, setters & adders
	
	public void setNavn (String s) {
		this.navn = s;
	}
	
	public String getNavn () {
		return this.navn;
	}
	
	public String getProjektNummer() {
		return this.projektNummer;
	}
	
	public int[] getStartUge() {
		return new int[] {this.startDato.beregnUge(), this.startDato.getYear()};
	}
	
	public void setStartUge(int uge, int year) {
		this.startDato = new Dato(uge, year);
	}
	
	public int[] getSlutUge() {
		return new int[]{this.slutDato.beregnUge(), this.slutDato.getYear()};
	}
	
	public void setSlutUge(int uge, int year) {
		this.slutDato = new Dato(uge, year);
	}
	
	public Medarbejder getLeder() {
		return this.projektleder;
	}
	
	public void setLeder(Medarbejder nyLeder) {
		this.projektleder = nyLeder;
	}
	
	public ArrayList<Medarbejder> getMedarbejdere() {
		return this.medarbejdere;
	}
	
	public void addMedarbejder(Medarbejder nyMed) {
		this.medarbejdere.add(nyMed);
	}
	
	public void addAktivitet(String navn, Dato startUge, Dato slutUge, int budgetTid) {
		this.aktiviteter.add(new Aktivitet(navn, startUge, slutUge, budgetTid));
	}

	public ArrayList<Aktivitet> getAktiviteter(){
		return this.aktiviteter;
	}
	
	//Formaterer projektets 
	public String getPackagedRapport() {
		String s = "";
		int tid = 0;
		for (Aktivitet a : this.aktiviteter)
		{
			s += ";" + a.getNavn() + "|" + a.getTime();
			tid += a.getTime();
		}
		s += ";TotalTid|" + tid;
		return s;
	}
}
