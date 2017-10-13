package app.team;

public class EvilTeam extends Team{
	
	public EvilTeam(int totalCount) {
		super(totalCount);
	}

	private int killCount = 1;
	
	public void markKillUsed(){
		killCount = 0;
	}
	
	public void resetKillCount(){
		killCount = 1;
	}
	
	public boolean isKillUsed(){
		return killCount>0;
	}
	
	
	
}
