package es.upm.miw.pwitter.model.handler.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.exceptions.CompetitionDeleteException;
import es.upm.miw.pwitter.model.exceptions.CompetitionInsertException;
import es.upm.miw.pwitter.model.exceptions.CompetitionUpdateException;
import es.upm.miw.pwitter.model.handler.FactoryCompetitions;
import es.upm.miw.pwitter.model.handler.IHandlerCompetitions;

@Component
public class HandlerCompetitions implements IHandlerCompetitions {

	@Inject
	private FactoryCompetitions factoryCompetitions;

	private final Set<Competition> competitions = new HashSet<Competition>();

	public HandlerCompetitions() {
	}

	@PostConstruct
	public void init() {
		this.addAllCompetition(this.factoryCompetitions.createDataSource());
	}

	public Set<Competition> getCompetitions() {
		return this.competitions;
	}

	public void addCompetition(Competition competition) {
		Integer id = this.getLastCorrectId();
		competition.setId(id);
		boolean insertCorrectly = this.competitions.add(competition);
		if (insertCorrectly == false) {
			throw new CompetitionInsertException(
					"La competition no se ha insertado porque ya exisitia");
		}
	}

	private Integer getLastCorrectId() {
		Integer id = 1;
		for (Competition competition : this.competitions) {
			if (competition.getId() > id) {
				id = competition.getId();
			}
		}
		id++;
		return id;
	}

	public void addAllCompetition(Set<Competition> listCompetitions) {
		this.competitions.addAll(listCompetitions);
	}

	public void removeCompetition(Competition competition) {
		boolean deleteCorrectly = this.competitions.remove(competition);
		if (deleteCorrectly == false) {
			throw new CompetitionDeleteException(
					"La competition no se ha borrado porque no exisitia");
		}
	}

	public void updateCompetition(Competition competition) {
		boolean deleteCorrectly = this.competitions.remove(competition);
		if (deleteCorrectly == false) {
			throw new CompetitionUpdateException(
					"La competition no se ha actualizado porque no exisitia");
		} else {
			this.competitions.add(competition);
		}
	}

	@Override
	public boolean hasNext() {
		return this.competitions.iterator().hasNext();
	}

	@Override
	public Competition next() {
		return this.competitions.iterator().next();
	}

	@Override
	public Competition findCompetition(Competition competition) {
		Competition result = null;
		for (Competition competitionIt : this.competitions) {
			if (competitionIt.equals(competition)) {
				result = competitionIt;
			}
		}
		return result;
	}

	@Override
	public Integer getNumCompetitions() {
		return this.competitions.size();
	}

}
