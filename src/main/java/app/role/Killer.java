package app.role;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.Status;
import app.team.EvilTeam;
import app.team.Team;

//@Component("killer")
@Scope("prototype")
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
