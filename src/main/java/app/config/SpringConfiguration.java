package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.aspect.Balance;
import app.role.Player;

@Configuration
@ComponentScan("main.app")
@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	@Bean
	public Balance balance(){
		return new Balance();
	}

}
