package es.upm.miw.pwitter.rest.server.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.handler.IHandlerCompetitions;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@RestController
@RequestMapping(value = Uris.COMPETITION)
public class CompetitionController {

	private final static Log LOG = LogFactory
			.getLog(CompetitionController.class);

	private static final String MESSAGE = "message";

	@Inject
	private IHandlerCompetitions handlerCompetitions;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertCompetition(@RequestBody Competition competition) {
		LOG.info("Se va a proceder a insertar una competicion");
		handlerCompetitions.addCompetition(competition);
		return this.getResponse("Competición insertada correctamente");
	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<Competition> getAllCompetitions() {
		LOG.info("Se recuperan todas las competiciones");
		return handlerCompetitions.getCompetitions();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Competition getCompetitionById(@PathVariable("id") Integer id) {
		LOG.info("Se recupera una competicion");
		Competition competition = new Competition(id);
		return handlerCompetitions.findCompetition(competition);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView updateCompetition(@RequestBody Competition competition) {
		LOG.info("Se va a proceder a actualizar una competicion");
		handlerCompetitions.updateCompetition(competition);
		return this.getResponse("Competición actualizada correctamente");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteCompetition(@PathVariable("id") Integer id) {
		LOG.info("Se va a proceder a borrar una competicion");
		handlerCompetitions.removeCompetition(new Competition(id));
		return this.getResponse("Competición borrada correctamente");
	}

	private ModelAndView getResponse(String msg) {
		LOG.info(msg);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(MESSAGE, msg);
		return new ModelAndView(new MappingJackson2JsonView(), jsonMap);
	}

}
