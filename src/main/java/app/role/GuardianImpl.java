package app.role;

import org.springframework.stereotype.Component;

import app.team.GoodTeam;
import app.team.Team;
@Component
public class GuardianImpl extends PlayerImpl implements NightOwl{
	private Role role = Role.GUARDIAN;
	
	public GuardianImpl(int number, Team goodTeam) {
		super(number, goodTeam);
		this.setRole(Role.GUARDIAN);
	}

	public GuardianImpl() {
	}

	@Override
	public void doNightAction() {
		
	}


	public void guard(Player target) {
		
	}
	
}
