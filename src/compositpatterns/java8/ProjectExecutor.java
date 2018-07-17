package compositpatterns.java8;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ProjectExecutor {

	private Project project;

	public ProjectExecutor(Project p) {
		this.project = p;
	}

	public Optional<Project> getProject() {
		return Optional.ofNullable(project);
	}

	public Manager getManager() {
		return getProject()
				.flatMap(Project::getTeam)
				.flatMap(Team::getManager)
				.orElseThrow(NoSuchElementException::new);
	}

}
