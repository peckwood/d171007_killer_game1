package app.role;

import org.springframework.stereotype.Component;

import app.team.GoodTeam;
import app.team.Team;

@Component("civilian")
public class Civilian extends PlayerImpl{
	private Role role = Role.CIVILIAN;
	
	public Civilian() {
	}

	public Civilian(int number, Team team) {
		super(number, team);
		this.setTeam(team);
	}
	
}
