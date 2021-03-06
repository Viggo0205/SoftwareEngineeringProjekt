// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class ProjectManager {
	private ArrayList<Project> projekter = new ArrayList<Project>();


	private static int findMedarbVedInit (String init, Project p, Aktivitet a) {
		for (Medarbejder m : p.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return p.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
	
	
	//Getters, setters, adders & finders
	
	public ArrayList<Project> getProjects() {
		return this.projekter;
	}

	public void addProject(Project projekt)	{
		this.projekter.add(projekt);
	}

	public int getProjektListLength() {
		return projekter.size();
	}

	public Project getCertainProject(int i) {
		return projekter.get(i);
	}
	
	public int findProjVedId(String id) {
		for (Project p : projekter)
		{
			if (p.getProjektNummer().equalsIgnoreCase(id))
				return projekter.indexOf(p);
		}
		return -1;
	}

	private static int findMedarbVedInit (String init, Project p) {
		for (Medarbejder m : p.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return p.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
	
	
			//Pakker data til klienten
	//Pakker alle projekter til klienten
	public String pakString() {
		String s = "";
		if(this.projekter.size() > 0)
			for (Project p : this.projekter)
			{
				s += ";" + p.getProjektNummer() + "|" + p.getNavn();
			}
		else
			s = ";";
		return s;
	}

	//Pakker alle projekter til klienten, samt tilhørende aktiviteter
	public String pakStringMedAkt() {
		String s = "";
		if(this.projekter.size() > 0)
			for (Project p : this.projekter)
			{
				s += ";" + p.getProjektNummer() + "|" + p.getNavn();
				if (p.getAktiviteter().size() > 0)
					for (Aktivitet a : p.getAktiviteter())
					{
						s += ":" + a.getNavn();
					}
			}
		return s;
	}

	//Pakker de projekter klienten selv er medlem af til vedkommende
	public String pakStringTake2(String init) {
		String s = "";
		if(this.projekter.size() > 0)
			for (Project p : this.projekter)
			{
				if (findMedarbVedInit(init, p) >= 0)
					s += ";" + p.getProjektNummer() + "|" + p.getNavn();
			}
		else
			s = ";";
		return s;
	}

	//Pakker de projekter klienten er medlem af, samt tilhørende aktiviteter, til vedkommende
	public String pakStringMedAktTake2(String init) {
		String s = "";
		if(this.projekter.size() > 0)
			for (Project p : this.projekter)
			{
				if (findMedarbVedInit(init, p) >= 0)
				{
					s += ";" + p.getProjektNummer() + "|" + p.getNavn();
					if (p.getAktiviteter().size() > 0)
						for (Aktivitet a : p.getAktiviteter())
						{
							if ( findMedarbVedInit(init, p, a) >= 0)
							s += ":" + a.getNavn();
						}
				}
			}
		return s;
	}
	
	// Pakker de projekter klienten er leder af til vedkommende
	public String pakStringTake3(String init) {
		String s = "";
		if(this.projekter.size() > 0)
			for (Project p : this.projekter)
			{
				if (p.getLeder().getInitialer().equalsIgnoreCase(init))
					s += ";" + p.getProjektNummer() + "|" + p.getNavn();
			}
		else
			s = ";";
		return s;
	}

	//Pakker de projekter klienten er leder af, samt tilhørende aktiviteter, til vedkommende
	public String pakStringMedAktTake3(String init) {
		String s = "";
		if(this.projekter.size() > 0)
			for (Project p : this.projekter)
			{
				if (findMedarbVedInit(init, p) >= 0)
				{
					s += ";" + p.getProjektNummer() + "|" + p.getNavn();
					if (p.getLeder().getInitialer().equalsIgnoreCase(init))
						for (Aktivitet a : p.getAktiviteter())
						{
							if ( findMedarbVedInit(init, p, a) >= 0)
							s += ":" + a.getNavn();
						}
				}
			}
		return s;
	}
}
