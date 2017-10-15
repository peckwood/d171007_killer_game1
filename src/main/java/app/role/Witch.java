package app.role;

import org.springframework.stereotype.Component;

import app.team.GoodTeam;
import app.team.Team;
@Component
public class Witch extends PlayerImpl implements NightOwl{
	private Role role = Role.WITCH;
	
	private int cureCount = 1;
	private int poisonCount = 1;
	
	public Witch(int number, Team goodTeam) {
		super(number, goodTeam);
		this.setRole(Role.WITCH);
	}
	
	private void poison(PlayerImpl player){
		if(poisonCount>0){
			poisonCount--;
		}
	}
	
	private void cure(PlayerImpl player){
		if(cureCount>0){
			cureCount--;
		}
	}

	@Override
	public void doNightAction() {
		//TODO
		PlayerImpl friend = null; 
		PlayerImpl victim = null;
		if(cureCount>0){
			cure(friend);
		}
		if(poisonCount>0){
			poison(victim);
		}
	}
}
