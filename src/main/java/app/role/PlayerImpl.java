package app.role;

import static app.Status.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.Status;
import app.team.Team;

@Component()
@Scope("prototype")
public class PlayerImpl implements Player{
	//号码
	private int number;
	private String nickname;
	private Status status = ALIVE;
	private Role role;
	private Team team;
	
	private Player killedBy;
	private int roundKilled;

	protected PlayerImpl(int number, Team team) {
		this.number = number;
		this.team = team;
	}
	
	protected PlayerImpl() {
	}
	
	@Override
	public void die(int roundKilled, Player killer){
		this.status = DEAD;
		this.killedBy = killer;
		this.roundKilled = roundKilled;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Player getKilledBy() {
		return killedBy;
	}
	public void setKilledBy(PlayerImpl killedBy) {
		this.killedBy = killedBy;
	}
	public int getRoundKilled() {
		return roundKilled;
	}
	public void setRoundKilled(int roundKilled) {
		this.roundKilled = roundKilled;
	}
	
	public Role getRole() {
		return role;
	}
	
	
	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
