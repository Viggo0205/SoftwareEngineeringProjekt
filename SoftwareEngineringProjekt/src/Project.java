import java.awt.*;
import java.util.ArrayList;
import java.io.Serializable;

/*
	Behandl lovlige uger client-side
	Giv kun setters til leder, behandles client-side
	Start- og slut-uger er egentligt datoer, men kan blot returneres som med .beregnUge()
*/

public class Project implements Serializable {
	private ArrayList<Aktivitet> aktiviteter = new ArrayList<Aktivitet>();
	private ArrayList<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
	private Medarbejder projektleder;
	private Dato startDato, slutDato;
	private String navn, projektNummer;
	
	public Project(String navn, Medarbejder projektleder, Dato startDato, Dato slutDato) throws NullPointerException {
		this.navn = navn;
		this.projektleder = projektleder;
		// Behandl lovlige uger client-side
		this.startDato = startDato;
		this.slutDato = slutDato;
		if (ServControll.getProjekter().getProjektListLength() > 0)
		{
			// Sidste oprettede projekts fulde nummer
			String s = ServControll.getProjekter().getProjects().get(ServControll.getProjekter().getProjektListLength() - 1).getProjektNummer();
			if ( s.substring(4, 10).equals("999999") )
			{
				throw new NullPointerException("No more room for projects this year");
			}
			if ( s.substring(0, 4).equals(Integer.toString(ServControll.getDato().getYear())))
			{
				this.projektNummer = Integer.toString(ServControll.getDato().getYear()) + nulStuff(Integer.toString(Integer.parseInt(s.substring(4, 10)) + 1));
			}
			else 
			{
				this.projektNummer = ServControll.getDato().getYear() + "000000";
			}
		}
		else this.projektNummer = "" + ServControll.getDato().getYear() + "000000";
		
		System.out.println("User " + projektleder.getInitialer() + " succesfully creates project " + navn + " with project number " + this.projektNummer);
	}
	
	// Anvendes til nulstuffing af projektnumre under 6 decimaler
	private String nulStuff(String s) {
		for ( int i = 6 - s.length(); i > 0; i--)
		{
			s = "0" + s;
		}
		return s;
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
	
	public int getCertainAkt(String navn) {
		for (Aktivitet a : this.aktiviteter)
		{
			if (a.getNavn().equalsIgnoreCase(navn))
				return this.aktiviteter.indexOf(a);
		}
		return -1;
	}
	
}
