package pretest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

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
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setEncoding("UTF-8");
	    characterEncodingFilter.setForceEncoding(true);
	    return characterEncodingFilter;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
