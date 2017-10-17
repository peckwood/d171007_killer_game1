package app.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import app.GameSetup;
import app.aspect.Balance;
import app.role.Civilian;
import app.role.Guardian;
import app.role.Killer;
import app.role.Player;
import app.role.PlayerFactory;
import app.role.Role;
import app.role.Seer;
import app.role.Witch;
import app.team.EvilTeam;
import app.team.GoodTeam;

@Configuration
@ComponentScan("app")
@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	@Bean
	public Balance balance(){
		return new Balance();
	}
	
/*	@Bean
	public Player player(Role playerRole, int playernumber, Team team){
		return Player.createPlayer(playerRole, playernumber, team);
	}*/
	
	@Bean
	public GoodTeam goodTeam(GameSetup gameSetup){
		return gameSetup.getGoodTeam();
	}
	@Bean
	public EvilTeam evilTeam(GameSetup gameSetup){
		return gameSetup.getEvilTeam();
	}
	
	@Bean
	public GameSetup gameSetup(Scanner scanner){
		GameSetup setup = new GameSetup();
/*		System.out.println("input the setup");
		setup.setSetupText(scanner.nextLine());
		System.out.println(setup.getSetupText());*/
		setup.setAllRolesList();
		setup.setupTeams();
		return setup;
	}
	@Bean
	@Scope("prototype")
	public Player seer(){
		return new Seer();
	}
	@Bean
	@Scope("prototype")
	public Player witch(){
		return new Witch();
	}
	@Bean
	@Scope("prototype")
	public Player guardian(){
		return new Guardian();
	}
	@Bean
	@Scope("prototype")
	public Player civilian(){
		return new Civilian();
	}
	
	@Bean
	public List<Player> players(GameSetup setup, GoodTeam goodTeam, EvilTeam evilTeam, PlayerFactory playerFactory){
		Random random = new Random();
		List<Player> players = new ArrayList<>();
		
		for(int i=0;i<setup.getTotalCount();i++){
			int currentPlayerNumber = i+1;;
			int currentRoleIndex= random.nextInt(setup.getAllRoleList().size());
			Player player = PlayerFactory.createPlayer(setup.getAllRoleList().get(currentRoleIndex), goodTeam, evilTeam, currentPlayerNumber);
			players.add(player);
			setup.getAllRoleList().remove(currentRoleIndex);
		}
		System.out.println("playersList :" + players);
		System.out.println();
		return players;
	}
	
/*	@Bean
	public Game game(List<Player> players){
		Game game = new Game();
		game.setPlayers(players);
		return game;
	}*/

	
	@Bean
	public Scanner scanner(){
		Scanner input = new Scanner(System.in);
		return input;
	}
	
/*    @Bean(name = "tool")
    public ToolFactory toolFactory() {
        ToolFactory factory = new ToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(2);
        return factory;
    }
 
    @Bean
    public Tool tool() throws Exception {
        return toolFactory().getObject();
    }*/
}
