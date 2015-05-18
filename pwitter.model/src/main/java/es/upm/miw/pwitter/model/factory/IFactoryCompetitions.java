package es.upm.miw.pwitter.model.factory;

import java.util.Date;
import java.util.List;
import java.util.Set;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Country;
import es.upm.miw.pwitter.model.beans.Match;
import es.upm.miw.pwitter.model.beans.Participant;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.model.beans.Sport;

public interface IFactoryCompetitions {

	Set<Competition> createDataSource();

	Competition createCompetition(Integer id, String name, Country country,
			Sport sport, List<Match> matchs);

	Match createMatch(Integer id, Participant local, Participant visitor,
			Date date, Result result);

	Participant createParticipant(String name);

}
