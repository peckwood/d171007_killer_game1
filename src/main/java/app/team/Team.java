package app.team;

public class Team {
	private int aliveCount;
	public Team(int totalCount) {
		this.aliveCount = totalCount;
	}
	public void recordLoss(){
		aliveCount--;
	}
	
	@Override
	public String toString() {
		return "Team [aliveCount=" + aliveCount + "]";
	}
	
}
