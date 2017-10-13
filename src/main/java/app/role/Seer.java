package app.role;

import app.team.GoodTeam;

public class Seer extends Player implements NightOwl{
	
	@Override
	public void doNightAction() {
		
	}

	public Seer(int number, GoodTeam goodTeam) {
		super(number, goodTeam);
		this.setRole(Role.SEER);
	}

	public Role identify(Player identified) {
		return identified.getRole();
	}
	
}
