package com.midi.samples.petclinic.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.midi.samples.petclinic.service.ClinicService;
import com.midi.samples.petclinic.web.PetTypeFormatter;

@Configuration
@EnableWebMvc
@Import(MvcViewConfig.class)
@ComponentScan(basePackages={"com.midi.samples.petclinic.web"})
public class MvcCoreConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ClinicService clinicService;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
	}

	@Bean
	public PetTypeFormatter petTypeFormatter() {
		return new PetTypeFormatter(clinicService);
	}
	

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(petTypeFormatter());
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true);
		configurer.defaultContentType(MediaType.TEXT_HTML);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// all resources inside folder src/main/webapp/resources are mapped so
		// they can be refered to inside JSP files (see header.jsp for more
		// details)
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
		// uses WebJars so Javascript and CSS libs can be declared as Maven dependencies (Bootstrap, jQuery...)
		registry.addResourceHandler("/webjars/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	
	
	
}
