package es.upm.miw.pwitter.model.handler.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import es.upm.miw.pwitter.model.beans.Competition;
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
		this.competitions.add(competition);
	}

	public void addAllCompetition(Set<Competition> listCompetitions) {
		this.competitions.addAll(listCompetitions);
	}

	public void removeCompetition(Competition competition) {
		this.competitions.remove(competition);
	}

	public void updateCompetition(Competition competition) {
		this.removeCompetition(competition);
		this.addCompetition(competition);
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
