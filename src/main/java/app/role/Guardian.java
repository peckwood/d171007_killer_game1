package app.role;

import org.springframework.stereotype.Component;

import app.team.GoodTeam;
import app.team.Team;
public class Guardian extends PlayerImpl implements NightOwl{
	private Role role = Role.GUARDIAN;
	
	public Guardian(int number, Team goodTeam) {
		super(number, goodTeam);
		this.setRole(Role.GUARDIAN);
	}

	public Guardian() {
	}

	@Override
	public void doNightAction() {
		
	}


	public void guard(Player target) {
		
	}
	
}
