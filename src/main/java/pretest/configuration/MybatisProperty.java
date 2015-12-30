package pretest.configuration;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 2015. 12. 29.
 * Copyright by joyhan / HUFS
 * MybatisProperty
 */
@ConfigurationProperties(prefix="mybatis")
@Component
public class MybatisProperty{
	private String configLocation;
	private String mapperLocation;
	
	public String getConfigLocation() {
		return configLocation;
	}
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}
	public String getMapperLocation() {
		return mapperLocation;
	}
	public void setMapperLocation(String mapperLocation) {
		this.mapperLocation = mapperLocation;
	}
	
}
