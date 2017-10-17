package app.role;

import org.springframework.stereotype.Component;

import app.team.EvilTeam;
import app.team.GoodTeam;
import app.team.Team;

@Component
public class PlayerFactory{

	public static Player createPlayer(Role playerRole, GoodTeam goodTeam, EvilTeam evilTeam, int playerNumber){
		switch (playerRole) {
		case CIVILIAN:
			return new Civilian(playerNumber, goodTeam);
		case GUARDIAN:
			return new Guardian(playerNumber, goodTeam);
		case KILLER:
			return new Killer(playerNumber, evilTeam);
		case SEER:
			return new Seer(playerNumber, goodTeam);
		case WITCH:
			return new Witch(playerNumber, goodTeam);
		default:
			return null;
		}
	}
}
