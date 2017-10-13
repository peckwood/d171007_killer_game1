package app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Balance {
	@After("execution(** app.role.Player.die(..))")
	public void checkBalance(){
		System.out.println("someone died");
	}
}
