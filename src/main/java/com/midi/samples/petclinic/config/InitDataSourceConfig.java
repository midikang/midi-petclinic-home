package com.midi.samples.petclinic.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@PropertySource("classpath:spring/data-access.properties")
public class InitDataSourceConfig {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Environment env;

	@PostConstruct
	public void init() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource(env.getProperty("jdbc.initLocation")));
		databasePopulator.addScript(new ClassPathResource(env.getProperty("jdbc.dataLocation")));
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
	}
}
