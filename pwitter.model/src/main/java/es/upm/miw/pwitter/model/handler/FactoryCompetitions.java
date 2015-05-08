package es.upm.miw.pwitter.model.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public Set<Competition> createDataSource() {
		Set<Competition> competitions = new HashSet<Competition>();
		try {

			Participant local;
			Participant visitor;
			Match match;
			List<Match> matchs;
			Competition competition;

			// COMPETICION BUNDESLIGA
			matchs = new ArrayList<Match>();

			local = createParticipant("Hamburgo");
			visitor = createParticipant("Schalke 04");
			match = createMatch(1, local, visitor,
					DATE_FORMATTER.parse("20/05/2016 22:00"),
					Result.SIN_DISPUTAR);
			matchs.add(match);

			local = createParticipant("Hannover 96");
			visitor = createParticipant("Bayer Munich");
			match = createMatch(2, local, visitor,
					DATE_FORMATTER.parse("10/05/2014 21:00"),
					Result.VICTORIA_LOCAL);
			matchs.add(match);

			local = createParticipant("Borussia Dortmund");
			visitor = createParticipant("Werder Bremen");
			match = createMatch(3, local, visitor,
					DATE_FORMATTER.parse("20/05/2013 12:00"), Result.EMPATE);
			matchs.add(match);

			competition = createCompetition(1, "Bundesliga", Country.ALEMANIA,
					Sport.FUTBOL, matchs);
			competitions.add(competition);

			// COMPETICION CALCIO
			matchs = new ArrayList<Match>();

			local = createParticipant("Juventus");
			visitor = createParticipant("Napoles");
			match = createMatch(4, local, visitor,
					DATE_FORMATTER.parse("20/05/2013 22:00"),
					Result.VICTORIA_LOCAL);
			matchs.add(match);

			local = createParticipant("Milan AC");
			visitor = createParticipant("Palermo");
			match = createMatch(5, local, visitor,
					DATE_FORMATTER.parse("20/05/2012 21:00"),
					Result.VICTORIA_VISITANTE);
			matchs.add(match);

			competition = createCompetition(2, "Calcio", Country.ITALIA,
					Sport.FUTBOL, matchs);
			competitions.add(competition);

			// COMPETICION ENDESA
			matchs = new ArrayList<Match>();

			local = createParticipant("Unicaja");
			visitor = createParticipant("Estudiantes");
			match = createMatch(6, local, visitor,
					DATE_FORMATTER.parse("12/05/2012 10:20"),
					Result.VICTORIA_VISITANTE);
			matchs.add(match);

			competition = createCompetition(3, "Liga Endesa", Country.ESPANA,
					Sport.BALONCESTO, matchs);
			competitions.add(competition);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return competitions;
	}

}
