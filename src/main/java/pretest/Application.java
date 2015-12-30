package pretest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;

import pretest.configuration.MvcConfiguration;

/**
 * 2015. 12. 28. Copyright by joyhan / HUFS Application
 */
// @ComponentScan
// @EnableAutoConfiguration
//@SpringApplicationConfiguration(classes =
// {MvcConfiguration.class})
@SpringBootApplication
@Configuration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
