package app.role;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import app.team.EvilTeam;
import app.team.GoodTeam;

public class PlayerFactory extends AbstractFactoryBean<PlayerImpl>{
	

	private GoodTeam goodTeam;
	private EvilTeam evilTeam;
	private int playerNumber;
	private Role playerRole;
	

	public PlayerFactory() {
		setSingleton(false);
	}

	@Override
	public Class<?> getObjectType() {
		return PlayerImpl.class;
	}

	@Override
	protected PlayerImpl createInstance() throws Exception {
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
	
	public void setGoodTeam(GoodTeam goodTeam) {
		this.goodTeam = goodTeam;
	}
	
	public void setEvilTeam(EvilTeam evilTeam) {
		this.evilTeam = evilTeam;
	}
}
