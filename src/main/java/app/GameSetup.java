package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import app.role.Civilian;
import app.role.Guardian;
import app.role.Killer;
import app.role.Player;
import app.role.Role;
import app.role.Seer;
import app.role.Witch;
import app.team.EvilTeam;
import app.team.GoodTeam;

public class GameSetup {
	EvilTeam evilTeam;
	GoodTeam goodTeam;
	private List<Player> players;
	private int totalCount;
	private int seerCount;
	private int killerCount;
	private int guardianCount;
	private int witchCount;
	private int civilianCount;
	
	public List<Player> setup(String counterText) {
		String[] counts = counterText.split(" ");//只支持一个空格
		totalCount = Integer.valueOf(counts[0]);
		killerCount = Integer.valueOf(counts[1]);
		seerCount = Integer.valueOf(counts[2]);
		witchCount = Integer.valueOf(counts[3]);
		guardianCount = Integer.valueOf(counts[4]);
		civilianCount = totalCount - seerCount - killerCount - guardianCount - witchCount;
		Map<Role, Integer> roleMap = new HashMap<>();
		roleMap.put(Role.KILLER, killerCount);
		roleMap.put(Role.SEER, seerCount);
		roleMap.put(Role.WITCH, witchCount );
		roleMap.put(Role.GUARDIAN, guardianCount);
		roleMap.put(Role.CIVILIAN, civilianCount);
		
		Role[] killerRoleArray = new Role[killerCount];
		Arrays.fill(killerRoleArray, Role.KILLER);
		Role[] seerRoleArray = new Role[seerCount];
		Arrays.fill(seerRoleArray, Role.SEER);
		Role[] witchRoleArray = new Role[witchCount];
		Arrays.fill(witchRoleArray, Role.WITCH);
		Role[] guardianRoleArray = new Role[guardianCount];
		Arrays.fill(guardianRoleArray, Role.GUARDIAN);
		Role[] civilianRoleArray = new Role[civilianCount];
		Arrays.fill(civilianRoleArray, Role.CIVILIAN);
		
		List<Role> allRoleList = new ArrayList<>();
		allRoleList.addAll(Arrays.asList(killerRoleArray));
		allRoleList.addAll(Arrays.asList(seerRoleArray));
		allRoleList.addAll(Arrays.asList(witchRoleArray));
		allRoleList.addAll(Arrays.asList(guardianRoleArray));
		allRoleList.addAll(Arrays.asList(civilianRoleArray));
		System.out.println(allRoleList);
		assignRoles(allRoleList);
		return players;
	}
	
	private void assignRoles(List<Role> allRoleList) {
		Random random = new Random();
		players = new ArrayList<>();
		evilTeam = new EvilTeam(killerCount);
		goodTeam = new GoodTeam(totalCount - killerCount, seerCount + witchCount, civilianCount);
		
		for(int i=0;i<totalCount;i++){
			int currentPlayerNumber = i+1;
			int currentRoleIndex= random.nextInt(allRoleList.size());
			switch(allRoleList.get(currentRoleIndex)){
			case KILLER:
				players.add(new Killer(currentPlayerNumber, evilTeam));
				break;
			case SEER:
				players.add(new Seer(currentPlayerNumber, goodTeam));
				break;
			case WITCH:
				players.add(new Witch(currentPlayerNumber, goodTeam));
				break;
			case GUARDIAN:
				players.add(new Guardian(currentPlayerNumber, goodTeam));
				break;
			case CIVILIAN:
				players.add(new Civilian(currentPlayerNumber, goodTeam));
				break;
			}
			allRoleList.remove(currentRoleIndex);
		}
		System.out.println(players);
	}

	@Override
	public String toString() {
		return "GameSetup [evilTeam=" + evilTeam + ", goodTeam=" + goodTeam + ", players=" + players + ", totalCount="
				+ totalCount + ", seerCount=" + seerCount + ", killerCount=" + killerCount + ", guardianCount="
				+ guardianCount + ", witchCount=" + witchCount + ", civilianCount=" + civilianCount + "]";
	}
	
	
	
}

