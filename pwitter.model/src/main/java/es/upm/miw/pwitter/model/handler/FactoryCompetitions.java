package es.upm.miw.pwitter.model.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Country;
import es.upm.miw.pwitter.model.beans.Match;
import es.upm.miw.pwitter.model.beans.Participant;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.model.beans.Sport;

@Component
public class FactoryCompetitions {

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	public Competition createCompetition(String name, Country country,
			Sport sport, List<Match> matchs) {
		return new Competition(matchs, name, country, sport);
	}

	public Match createMatch(Participant local, Participant visitor, Date date,
			Result result) {
		return new Match(local, visitor, date, result);
	}

	public Participant createParticipant(String name, Country country) {
		return new Participant(name, country);
	}

	public List<Competition> createDataSource() {
		List<Competition> competitions = new ArrayList<Competition>();
		try {

			Participant local;
			Participant visitor;
			Match match;
			List<Match> matchs;
			Competition competition;

			// COMPETICION BUNDESLIGA
			matchs = new ArrayList<Match>();

			local = createParticipant("Hamburgo", Country.ALEMANIA);
			visitor = createParticipant("Schalke 04", Country.ALEMANIA);
			match = createMatch(local, visitor,
					DATE_FORMATTER.parse("20/05/2016 22:00"),
					Result.SIN_DISPUTAR);
			matchs.add(match);

			local = createParticipant("Hannover 96", Country.ALEMANIA);
			visitor = createParticipant("Bayer Munich", Country.ALEMANIA);
			match = createMatch(local, visitor,
					DATE_FORMATTER.parse("10/05/2014 21:00"),
					Result.VICTORIA_LOCAL);
			matchs.add(match);

			local = createParticipant("Borussia Dortmund", Country.ALEMANIA);
			visitor = createParticipant("Werder Bremen", Country.ALEMANIA);
			match = createMatch(local, visitor,
					DATE_FORMATTER.parse("20/05/2013 12:00"), Result.EMPATE);
			matchs.add(match);

			competition = createCompetition("Bundesliga", Country.ALEMANIA,
					Sport.FUTBOL, matchs);
			competitions.add(competition);

			// COMPETICION CALCIO
			matchs = new ArrayList<Match>();

			local = createParticipant("Juventus", Country.ITALIA);
			visitor = createParticipant("Napoles", Country.ITALIA);
			match = createMatch(local, visitor,
					DATE_FORMATTER.parse("20/05/2013 22:00"),
					Result.VICTORIA_LOCAL);
			matchs.add(match);

			local = createParticipant("Milan AC", Country.ITALIA);
			visitor = createParticipant("Palermo", Country.ITALIA);
			match = createMatch(local, visitor,
					DATE_FORMATTER.parse("20/05/2012 21:00"),
					Result.VICTORIA_VISITANTE);
			matchs.add(match);

			competition = createCompetition("Calcio", Country.ITALIA,
					Sport.FUTBOL, matchs);
			competitions.add(competition);

			// COMPETICION ENDESA
			matchs = new ArrayList<Match>();

			local = createParticipant("Unicaja", Country.ESPANA);
			visitor = createParticipant("Estudiantes", Country.ESPANA);
			match = createMatch(local, visitor,
					DATE_FORMATTER.parse("12/05/2012 10:20"),
					Result.VICTORIA_VISITANTE);
			matchs.add(match);

			competition = createCompetition("Liga Endesa", Country.ESPANA,
					Sport.BALONCESTO, matchs);
			competitions.add(competition);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return competitions;
	}

}
