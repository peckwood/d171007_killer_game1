package app.role;

import org.springframework.stereotype.Component;

import app.Status;
import app.team.EvilTeam;
import app.team.Team;

@Component
public class KillerImpl extends PlayerImpl implements NightOwl{
	private Role role = Role.KILLER;
	
	@Override
	public void doNightAction() {
		
	}

	public KillerImpl(int number, Team evilTeam) {
		super(number, evilTeam);
	}
	public KillerImpl() {
	}

	public void kill(PlayerImpl victim) {
		victim.setStatus(Status.WOUNDED);
		
	}
	
}
