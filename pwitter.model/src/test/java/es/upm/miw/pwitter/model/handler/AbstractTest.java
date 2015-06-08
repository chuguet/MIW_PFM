package es.upm.miw.pwitter.model.handler;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import es.upm.miw.pwitter.model.config.SpringModelConfiguration;

@ContextConfiguration(classes = SpringModelConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class AbstractTest {

}
