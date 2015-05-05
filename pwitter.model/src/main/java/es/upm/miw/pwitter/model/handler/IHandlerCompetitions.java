package es.upm.miw.pwitter.model.handler;

import java.util.Iterator;
import java.util.List;

import es.upm.miw.pwitter.model.beans.Competition;

public interface IHandlerCompetitions extends Iterator<Competition> {

	List<Competition> getCompetitions();

	void addCompetition(Competition competition);

	void addAllCompetition(List<Competition> listCompetitions);

	void removeCompetition(Competition competition);

	void updateCompetition(Competition competition);

	Competition findCompetition(Competition competition);

}
