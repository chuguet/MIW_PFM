package es.upm.miw.pwitter.rest.server.config;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan("es.upm.miw.pwitter.rest.server")
public class SpringRestConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	@Inject
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(
			MappingJackson2JsonView mappingJackson2JsonView) {
		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		ArrayList<View> defaultViews = new ArrayList<View>();
		defaultViews.add(mappingJackson2JsonView);
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		return contentNegotiatingViewResolver;
	}

	@Bean
	public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager
				.setDefaultContentType(MediaType.APPLICATION_JSON);
		return contentNegotiationManager;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Bean
	public MappingJackson2JsonView mappingJacksonJsonView() {
		return new MappingJackson2JsonView();
	}

}
