package compositpatterns.prejava8;

import java.util.NoSuchElementException;

public class ProjectExecutor {

	private Project project;

	public ProjectExecutor(Project p) {
		this.project = p;
	}
	
	public Project getProject() {
		return project;
	}

	public Manager getManager() {
		Project project = getProject();
		if(project != null) {
			Team team = project.getTeam();
			if(team != null) {
				Manager manager = team.getManager();
				if(manager != null) {
					return manager;
				}
			}
		}
		throw new NoSuchElementException();
	}
	
}
