import java.util.ArrayList;

public class ProjectManager {
	private ArrayList<Project> projekter = new ArrayList<Project>();
	
	public ArrayList<Project> getProjects() {
		return this.projekter;
	}
	
	public int addProject(String projektNavn, Medarbejder projektleder, Dato startUge, Dato slutUge)
	{
		this.projekter.add(new Project(projektNavn, projektleder, startUge, slutUge));
		return 200;
	}
	
	public int getProjektListLength() {
		return projekter.size();
	}
}
