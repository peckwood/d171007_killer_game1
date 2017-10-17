package app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import app.Game;
import app.role.Player;

@Aspect
public class Balance {
	
	@Autowired
	private Game game;
	
	@After("execution(** app.role.Player.die(int, app.role.Player) ) "
			+ "&& within(app.role.*) "
			+ "&& args(round,murderer)")
	public void checkBalance(int round, Player murderer){
		game.checkGameStatus();
	}
	
	@Around("execution(** app.role.Player.die(int, app.role.Player) ) && within(app.role.*)")
	public void around(ProceedingJoinPoint point) throws Throwable{
		System.out.println("around1");
		point.proceed();
		System.out.println("around2");
	}
}
