package com.miw.pwitter.rest.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan("com.miw.pwitter.rest.server")
public class SpringRestConfiguration {

	@Bean
	public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager
				.setDefaultContentType(MediaType.APPLICATION_JSON);
		return contentNegotiationManager;
	}

	@Bean
	public MappingJackson2JsonView mappingJacksonJsonView() {
		return new MappingJackson2JsonView();
	}

}
