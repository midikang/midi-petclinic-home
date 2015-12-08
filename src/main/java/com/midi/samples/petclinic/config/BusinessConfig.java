package com.midi.samples.petclinic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.midi.samples.petclinic.service")
// To find ClinicService
@PropertySource("classpath:spring/data-access.properties")
@EnableTransactionManagement
@Import({DataSourceConfig.class, InitDataSourceConfig.class, JpaConfig.class})
public class BusinessConfig {

	
	
	
}
