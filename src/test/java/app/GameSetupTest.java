package app;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.GameSetup;
import app.config.SpringConfiguration;
import app.role.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class)
public class GameSetupTest {
	@Test
	public void testSetup(){
		GameSetup setup = new GameSetup();
		List<Player> players = setup.setup("10 2 3 2 2");
		
		System.out.println(setup);
		System.out.println("players: "+ players);
		players.get(0).die(1, players.get(1));
		
	}
}
