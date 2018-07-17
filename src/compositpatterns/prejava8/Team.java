package compositpatterns.prejava8;

public class Team {

	private Manager manager;

	public Team(Manager manager) {
		this.manager = manager;
	}
	
	public Manager getManager() {
		return manager;
	}
}
