package pretest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * 2015. 12. 28.
 * Copyright by joyhan / HUFS
 * Application
 */
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@Profile(value="local")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
