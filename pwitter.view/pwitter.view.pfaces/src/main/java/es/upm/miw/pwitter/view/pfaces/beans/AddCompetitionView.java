package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Match;
import es.upm.miw.pwitter.model.beans.Message;
import es.upm.miw.pwitter.model.beans.Participant;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@ManagedBean(name = "addCompetition")
@ViewScoped
public class AddCompetitionView extends AbstractCompetitionView implements
		Serializable {

	private final static Log LOG = LogFactory.getLog(AddCompetitionView.class);

	private static final long serialVersionUID = 1L;

	private Competition competition;

	public AddCompetitionView() {
		super();
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	@PostConstruct
	public void update() {
		LOG.info("Update Add Competition View");
		competition = new Competition();
		competition.setMatchs(new ArrayList<Match>());
	}

	public String removeMatch() {
		LOG.info("Remove the last Match");
		competition.getMatchs().remove(competition.getMatchs().size() - 1);
		return null;
	}

	public String addMatch() {
		LOG.info("Add generic Match");
		competition.getMatchs().add(
				new Match(competition.getMatchs().size() + 1, new Participant(
						""), new Participant(""), new Date(),
						Result.SIN_DISPUTAR));
		return null;
	}

	public String process() {
		LOG.info("Add Competition action");
		this.restClient.postForObject(API_URI + Uris.COMPETITION, competition,
				Message.class);
		return null;
	}

}
