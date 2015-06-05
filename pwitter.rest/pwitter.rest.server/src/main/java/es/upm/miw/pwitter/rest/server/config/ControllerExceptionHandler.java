package es.upm.miw.pwitter.rest.server.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import es.upm.miw.pwitter.model.exceptions.CompetitionException;

@ControllerAdvice
public class ControllerExceptionHandler {

	private final static Log LOG = LogFactory
			.getLog(ControllerExceptionHandler.class);

	private static final String MESSAGE = "msg.error";

	@ExceptionHandler(CompetitionException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ModelAndView handleInsertException(CompetitionException ex) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(MESSAGE, ex.getMessage());
		LOG.error(ex.getMessage());
		return new ModelAndView(new MappingJackson2JsonView(), jsonMap);
	}
}
