package es.upm.miw.pwitter.model.handler;

import java.util.Iterator;
import java.util.Set;

import es.upm.miw.pwitter.model.beans.Competition;

public interface IHandlerCompetitions extends Iterator<Competition> {

	Set<Competition> getCompetitions();

	void addCompetition(Competition competition);

	void addAllCompetition(Set<Competition> listCompetitions);

	void removeCompetition(Competition competition);

	void updateCompetition(Competition competition);

	Competition findCompetition(Competition competition);

	Integer getNumCompetitions();

}
