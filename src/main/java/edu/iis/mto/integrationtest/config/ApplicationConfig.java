package edu.iis.mto.integrationtest.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import edu.iis.mto.integrationtest.utils.ModeUtils;


@Configuration //wskazuje, ze klasa zawiera konfiguracje bean’ów Spring
@ComponentScan("edu.iis.mto.integrationtest.repository") //ustala kontekst poszukiwania komponentów
@Import(value = { PersistenceConfig.class }) //klasa zwiazana z konfiguracja bean’ów, która importujemy
public class ApplicationConfig {

	@Bean
	public static PropertyPlaceholderConfigurer configBean(){
		PropertyPlaceholderConfigurer resolver = new PropertyPlaceholderConfigurer();
		resolver.setLocation(new ClassPathResource(ModeUtils.getMode().getModeName() + "-persistence.properties"));
		
		return resolver;
	}
	
}