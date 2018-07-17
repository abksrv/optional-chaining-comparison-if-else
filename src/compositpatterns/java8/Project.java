package compositpatterns.java8;

import java.util.Optional;

public class Project {

	private Team team;

	public Project(Team team) {
		this.team = team;
	}
	
	public Optional<Team> getTeam() {
		return Optional.ofNullable(team);
	}
}
