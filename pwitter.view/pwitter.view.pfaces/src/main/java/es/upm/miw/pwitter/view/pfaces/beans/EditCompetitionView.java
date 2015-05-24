package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Match;
import es.upm.miw.pwitter.model.beans.Participant;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@ManagedBean(name = "editCompetition")
@ViewScoped
public class EditCompetitionView extends AbstractCompetitionView implements
		Serializable {

	private final static Log LOG = LogFactory.getLog(EditCompetitionView.class);

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{competitionList}")
	private ListCompetitionsView listCompetition;

	private Competition competition;

	public EditCompetitionView() {
		super();
	}

	public ListCompetitionsView getListCompetition() {
		return listCompetition;
	}

	public void setListCompetition(ListCompetitionsView listCompetition) {
		this.listCompetition = listCompetition;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	@PostConstruct
	public void update() {
		LOG.info("Update Edit view");
		competition = listCompetition.getSelectedCompetition();
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
						" "), new Participant(" "), new Date(),
						Result.SIN_DISPUTAR));
		return null;
	}

	public void process() {
		LOG.info("Process update data: " + competition.toString());
		restClient.put(API_URI + Uris.COMPETITION, competition);
	}

}
