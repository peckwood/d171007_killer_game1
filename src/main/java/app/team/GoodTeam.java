package app.team;

import app.role.Role;

public class GoodTeam extends Team{
	public GoodTeam(int totalCount, int godAlive, int civilianAlive) {
		super(totalCount);
		this.godAlive = godAlive;
		this.civilianAlive = civilianAlive;
		
		/*Predicate<Player> playerIsGod = player -> player.getRole().isIS_GOD()==true;
		gods = teamPlayers.stream()
		.filter(playerIsGod)
		.collect(Collectors.toList());
		
		Predicate<Player> playerIsCivilian = player -> player.getRole()==Role.CIVILIAN;
		civilians = teamPlayers.stream()
		.filter(playerIsCivilian)
		.collect(Collectors.toList());*/
	}
	/*private List<Player> gods;
	private List<Player> civilians;*/
	
	private int godAlive;
	private int civilianAlive;
	@Override
	public String toString() {
		return super.toString() + "| GoodTeam [godCount=" + godAlive + ", civilianCount=" + civilianAlive + "]";
	}
	
	public void recordLoss(Role role) {
		super.recordLoss();
		if(role.isIS_GOD()){
			godAlive--;
		}else{
			civilianAlive--;
		}
	}
	
}
