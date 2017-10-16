package app.role;

import app.team.EvilTeam;
import app.team.Team;

public interface Player {

	void die(int roundKilled, Player killer);

	void setNumber(int playerNumber);

	void setTeam(Team team);

	int getNumber();
}
