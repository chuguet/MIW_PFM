package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.client.RestClientException;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@ManagedBean(name = "competitionList")
@SessionScoped
public class ListCompetitionsView extends AbstractCompetitionView implements
		Serializable {

	private final static Log LOG = LogFactory
			.getLog(ListCompetitionsView.class);

	private static final long serialVersionUID = 1L;

	private List<Competition> competitionList;

	private Competition selectedCompetition;

	public ListCompetitionsView() {
		super();
	}

	@PostConstruct
	public void update() {
		LOG.info("Update List view");
		try {
			Competition[] competitions = restClient.getForObject(API_URI
					+ Uris.COMPETITION, Competition[].class);

			competitionList = Arrays.asList(competitions);
		} catch (RestClientException ex) {
			competitionList = new ArrayList<Competition>();
		}
	}

	public List<Competition> getCompetitionList() {
		return competitionList;
	}

	public void setCompetitionList(List<Competition> competitionList) {
		this.competitionList = competitionList;
	}

	public Competition getSelectedCompetition() {
		return selectedCompetition;
	}

	public void setSelectedCompetition(Competition selectedCompetition) {
		this.selectedCompetition = selectedCompetition;
	}

	public String detailAction(Competition Competition) {
		return "detailCompetition";
	}

	public String editAction(Competition Competition) {
		LOG.info("EditAction: " + Competition.toString());
		setSelectedCompetition(Competition);
		return "editCompetition";
	}

	public void removeAction(Integer competitionId) {
		LOG.info("RemoveAction for competition: " + competitionId);
		restClient.delete(API_URI + Uris.COMPETITION + "/" + competitionId);
		update();
	}

}
