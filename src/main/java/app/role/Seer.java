package app.role;

import org.springframework.stereotype.Component;

import app.team.Team;

public class Seer extends PlayerImpl implements NightOwl{
	private Role role = Role.SEER;
	
	
	@Override
	public void doNightAction() {
		
	}

	public Seer() {
	}

	public Seer(int number, Team goodTeam) {
		super(number, goodTeam);
		this.setRole(Role.SEER);
	}

	public Role identify(PlayerImpl identified) {
		return identified.getRole();
	}
	
}
