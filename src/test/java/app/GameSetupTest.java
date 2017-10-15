package app;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.GameSetup;
import app.config.SpringConfiguration;
import app.role.PlayerImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class)
public class GameSetupTest {
	@Autowired
	private Game game;
	
	@Test
	public void testSetup(){
		System.out.println(game.getPlayers());
		game.getPlayers().get(0).die(1, game.getPlayers().get(1));
	}
}
