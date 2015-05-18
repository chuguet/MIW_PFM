package es.upm.miw.pwitter.model.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Country;
import es.upm.miw.pwitter.model.beans.Match;
import es.upm.miw.pwitter.model.beans.Participant;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.model.beans.Sport;
import es.upm.miw.pwitter.model.exceptions.CompetitionCreateException;

@Component
public class FactoryCompetitions {

	private final static Log LOG = LogFactory.getLog(FactoryCompetitions.class);

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	public Set<Competition> createDataSource() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(DATE_FORMATTER);
			return mapper.readValue(
					getClass().getResourceAsStream("/competitions.json"),
					new TypeReference<Set<Competition>>() {
					});
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new CompetitionCreateException(
					"Error al inicializarse los partidos");
		}
	}

	public Competition createCompetition(Integer id, String name,
			Country country, Sport sport, List<Match> matchs) {
		return new Competition(id, matchs, name, country, sport);
	}

	public Match createMatch(Integer id, Participant local,
			Participant visitor, Date date, Result result) {
		return new Match(id, local, visitor, date, result);
	}

	public Participant createParticipant(String name) {
		return new Participant(name);
	}

}
