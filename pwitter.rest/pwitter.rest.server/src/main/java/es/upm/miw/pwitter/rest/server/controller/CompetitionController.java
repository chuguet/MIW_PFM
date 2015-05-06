package es.upm.miw.pwitter.rest.server.controller;

import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Message;
import es.upm.miw.pwitter.model.exceptions.CompetitionException;
import es.upm.miw.pwitter.model.handler.IHandlerCompetitions;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@RestController
@RequestMapping(value = Uris.COMPETITION)
public class CompetitionController {

	private final static Log LOG = LogFactory
			.getLog(CompetitionController.class);

	@Inject
	private IHandlerCompetitions handlerCompetitions;

	@RequestMapping(method = RequestMethod.POST)
	public Message insertCompetition(@RequestBody Competition competition) {
		LOG.info("Se va a proceder a insertar una competicion");
		Message result;
		try {
			handlerCompetitions.addCompetition(competition);
			result = new Message("Competicion insertada correctamente",
					Boolean.TRUE);
		} catch (CompetitionException ex) {
			result = new Message(ex.getMessage(), Boolean.FALSE);
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<Competition> getAllCompetitions() {
		LOG.info("Se recuperan todas las competiciones");
		return handlerCompetitions.getCompetitions();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Competition getCompetitionByNameCountryAndSport(
			@PathVariable("id") Integer id) {
		LOG.info("Se recupera una competicion");
		Competition competition = new Competition(id);
		return handlerCompetitions.findCompetition(competition);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Message updateCompetition(@RequestBody Competition competition) {
		LOG.info("Se va a proceder a actualizar una competicion");
		Message result;
		try {
			handlerCompetitions.updateCompetition(competition);
			result = new Message("Competicion actualizada correctamente",
					Boolean.TRUE);
		} catch (CompetitionException ex) {
			result = new Message(ex.getMessage(), Boolean.FALSE);
		}
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Message deleteCompetition(@PathVariable("id") Integer id) {
		LOG.info("Se va a proceder a borrar una competicion");
		Message result;
		try {
			handlerCompetitions.removeCompetition(new Competition(id));
			result = new Message("Competicion eliminada correctamente",
					Boolean.TRUE);
		} catch (CompetitionException ex) {
			result = new Message(ex.getMessage(), Boolean.FALSE);
		}
		return result;
	}

}
