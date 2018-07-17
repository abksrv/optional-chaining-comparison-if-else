package compositpatterns.java8;

import java.util.Optional;

public class Team {

	private Manager manager;

	public Team(Manager manager) {
		this.manager = manager;
	}
	
	public Optional<Manager> getManager() {
		return Optional.ofNullable(manager);
	}
}
