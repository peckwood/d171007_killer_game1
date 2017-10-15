package app.role;

import app.team.EvilTeam;
import app.team.Team;

public interface Player {
	
	public static Player createPlayer(Role playerRole, int playerNumber, Team team){
		switch (playerRole) {
		case CIVILIAN:
			return new Civilian(playerNumber, team);
		case GUARDIAN:
			return new GuardianImpl(playerNumber, team);
		case KILLER:
			return new KillerImpl(playerNumber, team);
		case SEER:
			return new Seer(playerNumber, team);
		case WITCH:
			return new Witch(playerNumber, team);
		default:
			return null;
		}
	}

	void die(int roundKilled, Player killer);

	void setNumber(int playerNumber);

	void setTeam(Team team);

	int getNumber();
}
