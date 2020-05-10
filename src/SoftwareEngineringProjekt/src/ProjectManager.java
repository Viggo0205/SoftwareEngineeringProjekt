// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class ProjectManager {
	private ArrayList<Project> projekter = new ArrayList<Project>();

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

	private static int findMedarbVedInit (String init, Project p) {
		for (Medarbejder m : p.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return p.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
	private static int findMedarbVedInit (String init, Project p, Aktivitet a) {
		for (Medarbejder m : p.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return p.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
}
