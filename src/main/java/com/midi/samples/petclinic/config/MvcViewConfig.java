package com.midi.samples.petclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.midi.samples.petclinic.model.Vets;

@Configuration
public class MvcViewConfig {

	@Bean
	@Description("Default viewClass: JSTL view(JSP with html output")
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	@Bean
	@Description("Used for 'xml' views")
	public ViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}
	
	@Bean(name="vets/vetList.xml")
	@Description("Renders an XML view. Used by the BeanNameViewResolver")
	public MarshallingView marshallingView() {
		return new MarshallingView(marshaller());
	}

	@Bean
	@Description("Object-XML mapping declared using annotations inside 'Vets'")
	public Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Vets.class);
		return marshaller;
	}
}
