package es.upm.miw.pwitter.model.handler;

import java.util.Iterator;
import java.util.Set;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.exceptions.CompetitionException;

public interface IHandlerCompetitions extends Iterator<Competition> {

	Set<Competition> getCompetitions();

	void addCompetition(Competition competition) throws CompetitionException;

	void addAllCompetition(Set<Competition> listCompetitions);

	void removeCompetition(Competition competition) throws CompetitionException;

	void updateCompetition(Competition competition) throws CompetitionException;

	Competition findCompetition(Competition competition);

	Integer getNumCompetitions();

}
