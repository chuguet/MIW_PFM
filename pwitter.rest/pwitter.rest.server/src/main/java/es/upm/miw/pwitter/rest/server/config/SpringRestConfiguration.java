package es.upm.miw.pwitter.rest.server.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.upm.miw.pwitter.model.config.SpringModelConfiguration;

@Configuration
@EnableWebMvc
@Import(SpringModelConfiguration.class)
@ComponentScan("es.upm.miw.pwitter.rest.server")
public class SpringRestConfiguration extends WebMvcConfigurerAdapter {

	private static final String PATTERN_DATE = "dd/MM/yyyy HH:mm";

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(customConverter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter customConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat(PATTERN_DATE));
		converter.setObjectMapper(objectMapper);
		return converter;
	}

}
