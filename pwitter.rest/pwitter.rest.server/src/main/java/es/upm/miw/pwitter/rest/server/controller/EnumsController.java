package es.upm.miw.pwitter.rest.server.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.pwitter.model.beans.Country;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.model.beans.Sport;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@RestController
public class EnumsController {

	private final static Log LOG = LogFactory.getLog(EnumsController.class);

	@RequestMapping(value = Uris.COUNTRIES, method = RequestMethod.GET)
	public List<Country> getCountries() {
		LOG.info("Se recuperan todos los paises");
		return Arrays.asList(Country.values());
	}

	@RequestMapping(value = Uris.RESULTS, method = RequestMethod.GET)
	public List<Result> getResults() {
		LOG.info("Se recuperan todos los resultados");
		return Arrays.asList(Result.values());
	}

	@RequestMapping(value = Uris.SPORTS, method = RequestMethod.GET)
	public List<Sport> getSports() {
		LOG.info("Se recuperan todos los deportes");
		return Arrays.asList(Sport.values());
	}

}
