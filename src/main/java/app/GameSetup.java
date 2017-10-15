package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import app.role.Civilian;
import app.role.GuardianImpl;
import app.role.KillerImpl;
import app.role.PlayerImpl;
import app.role.Role;
import app.role.Seer;
import app.role.Witch;
import app.team.EvilTeam;
import app.team.GoodTeam;

public class GameSetup {
	private String roleCounterText = "10 2 3 2 2";
	private List<Role> allRoleList = new ArrayList<>();
	
	private EvilTeam evilTeam;
	private GoodTeam goodTeam;
	private List<PlayerImpl> players;
	private int totalCount;
	private int seerCount;

	private int killerCount;
	private int guardianCount;
	private int witchCount;
	private int civilianCount;
	
	public void setupTeams(){
		evilTeam = new EvilTeam(killerCount);
		goodTeam = new GoodTeam(totalCount - killerCount, seerCount + witchCount, civilianCount);
	}
	
	public void setAllRolesList(){
		String[] counts = roleCounterText.split(" ");//只支持一个空格
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
		allRoleList.addAll(Arrays.asList(killerRoleArray));
		allRoleList.addAll(Arrays.asList(seerRoleArray));
		allRoleList.addAll(Arrays.asList(witchRoleArray));
		allRoleList.addAll(Arrays.asList(guardianRoleArray));
		allRoleList.addAll(Arrays.asList(civilianRoleArray));
		System.out.println(allRoleList);
	}

	public List<PlayerImpl> setup() {
//		setAllRolesList();
//		setupTeams();
		assignRoles(allRoleList);
		return players;
	}
	
	private void assignRoles(List<Role> allRoleList) {
		Random random = new Random();
		players = new ArrayList<>();
		
		for(int i=0;i<totalCount;i++){
			int currentPlayerNumber = i+1;
			int currentRoleIndex= random.nextInt(allRoleList.size());
			switch(allRoleList.get(currentRoleIndex)){
			case KILLER:
				players.add(new KillerImpl(currentPlayerNumber, evilTeam));
				break;
			case SEER:
				players.add(new Seer(currentPlayerNumber, goodTeam));
				break;
			case WITCH:
				players.add(new Witch(currentPlayerNumber, goodTeam));
				break;
			case GUARDIAN:
				players.add(new GuardianImpl(currentPlayerNumber, goodTeam));
				break;
			case CIVILIAN:
				players.add(new Civilian(currentPlayerNumber, goodTeam));
				break;
			}
			allRoleList.remove(currentRoleIndex);
		}
		System.out.println(players);
	}

	public List<Role> getAllRoleList() {
		return allRoleList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public String toString() {
		return "GameSetup [roleCounterText=" + roleCounterText + ", allRoleList=" + allRoleList + ", evilTeam="
				+ evilTeam + ", goodTeam=" + goodTeam + ", players=" + players + ", totalCount=" + totalCount
				+ ", seerCount=" + seerCount + ", killerCount=" + killerCount + ", guardianCount=" + guardianCount
				+ ", witchCount=" + witchCount + ", civilianCount=" + civilianCount + "]";
	}

	public EvilTeam getEvilTeam() {
		return evilTeam;
	}

	public void setEvilTeam(EvilTeam evilTeam) {
		this.evilTeam = evilTeam;
	}

	public GoodTeam getGoodTeam() {
		return goodTeam;
	}

	public void setGoodTeam(GoodTeam goodTeam) {
		this.goodTeam = goodTeam;
	}

	public List<PlayerImpl> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerImpl> players) {
		this.players = players;
	}
	
	
}

