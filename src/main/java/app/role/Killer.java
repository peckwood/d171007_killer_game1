package app.role;

import org.springframework.stereotype.Component;

import app.Status;
import app.team.EvilTeam;

@Component
public class Killer extends Player implements NightOwl{
	
	@Override
	public void doNightAction() {
		
	}

	public Killer(int number, EvilTeam evilTeam) {
		super(number, evilTeam);
		this.setRole(Role.KILLER);
	}



	public void kill(Player victim) {
		victim.setStatus(Status.WOUNDED);
		
	}
	
}
