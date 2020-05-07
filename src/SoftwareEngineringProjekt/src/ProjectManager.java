// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class ProjectManager {
	private ArrayList<Project> projekter = new ArrayList<Project>();
	
	public ArrayList<Project> getProjects() {
		return this.projekter;
	}
	
	public int addProject(Project projekt)
	{
		this.projekter.add(projekt);
		return 200;
	}
	
	public int getProjektListLength() {
		return projekter.size();
	}
	
	public Project getCertainProject(int i) {
		return projekter.get(i);
	}
}
