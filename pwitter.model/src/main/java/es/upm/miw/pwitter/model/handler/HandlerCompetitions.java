package es.upm.miw.pwitter.model.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import es.upm.miw.pwitter.model.beans.Competition;

@Component
public class HandlerCompetitions implements Iterator<Competition> {

	@Inject
	private FactoryCompetitions factoryCompetitions;

	private final List<Competition> competitions = new ArrayList<Competition>();

	public HandlerCompetitions() {
		this.addAllCompetition(this.factoryCompetitions.createDataSource());
	}

	public List<Competition> getCompetitions() {
		return this.competitions;
	}

	public void addCompetition(Competition competition) {
		this.competitions.add(competition);
	}

	public void addAllCompetition(List<Competition> listCompetitions) {
		this.competitions.addAll(competitions);
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

}
