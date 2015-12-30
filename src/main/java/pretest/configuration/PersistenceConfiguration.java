package pretest.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 2015. 12. 29.
 * Copyright by joyhan / HUFS
 * PersistenceConfiguration
 */

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {
	
	@Autowired
	MybatisProperty mybatisProperty;
	
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource( mybatisProperty.getConfigLocation() ));
        factoryBean.setMapperLocations(applicationContext.getResources( mybatisProperty.getMapperLocation() ));

        return factoryBean;
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}