package es.upm.miw.pwitter.rest.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import es.upm.miw.pwitter.model.config.SpringModelConfiguration;

@Configuration
@EnableWebMvc
@Import(SpringModelConfiguration.class)
@ComponentScan("es.upm.miw.pwitter.rest.server")
public class SpringRestConfiguration extends WebMvcConfigurerAdapter {

}
