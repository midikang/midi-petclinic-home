package com.midi.samples.petclinic.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.midi.samples.petclinic.service.ClinicService;
import com.midi.samples.petclinic.service.YfsService;
import com.midi.samples.petclinic.web.CommonCodeFormatter;
import com.midi.samples.petclinic.web.PetTypeFormatter;

@Configuration
@EnableWebMvc
@Import(MvcViewConfig.class)
@ComponentScan(basePackages={"com.midi.samples.petclinic.web"})
public class MvcCoreConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private YfsService yfsService;
    
    @Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true);
		configurer.defaultContentType(MediaType.TEXT_HTML);
		configurer.mediaType("html", MediaType.TEXT_HTML);
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
    
    @Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(petTypeFormatter());
	}

    @Bean
	public PetTypeFormatter petTypeFormatter() {
		return new PetTypeFormatter(clinicService);
	}
    
    @Bean
    public CommonCodeFormatter commonCodeFormatter() {
    		return new CommonCodeFormatter(yfsService);
    }
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// all resources inside folder src/main/webapp/resources are mapped so
		// they can be refered to inside JSP files (see header.jsp for more
		// details)
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
    
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
	}

	@Bean(name="messageSource")
	@Description("Message source for this context, loaded from localization 'message_xx' files.")
	public ReloadableResourceBundleMessageSource eloadableResourceBundleMessageSource() {
		// Files are stored inside src/main/resources
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages/messages");
		return messageSource;
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver>
		exceptionResolvers) {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		// results into 'WEB-INF/jsp/exception.jsp'
		exceptionResolver.setDefaultErrorView("exception");
		// needed otherwise exception won't be logged anywhere
		exceptionResolver.setWarnLogCategory("warn");
		exceptionResolvers.add(exceptionResolver);
	}




	
	
	
}
