package app.role;

import app.Status;
import app.team.Team;

public class Killer extends PlayerImpl implements NightOwl{
	private Role role = Role.KILLER;
	
	@Override
	public void doNightAction() {
		
	}

	public Killer(int number, Team evilTeam) {
		super(number, evilTeam);
	}
	public Killer() {
	}

	public void kill(PlayerImpl victim) {
		victim.setStatus(Status.WOUNDED);
		
	}
	
}
