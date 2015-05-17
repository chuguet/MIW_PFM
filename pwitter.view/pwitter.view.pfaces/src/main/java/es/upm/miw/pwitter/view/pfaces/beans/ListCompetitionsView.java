package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.web.client.RestClientException;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@ManagedBean
@ViewScoped
public class ListCompetitionsView extends AbstractCompetitionView implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private List<Competition> competitionList;

	private Competition selectedCompetition;

	public ListCompetitionsView() {
		super();
	}

	@PostConstruct
	public void update() {
		try {
			competitionList = new ArrayList<Competition>(
					restClient.getForObject(API_URI + Uris.COMPETITION,
							Set.class));
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

	public String detailAction(ActionEvent actionEvent) {
		return "competitionDetail";
	}

	public String editAction(Competition Competition) {
		setSelectedCompetition(Competition);
		return "editCompetition";
	}

	public void removeAction(Integer competitionId) {
		restClient.delete(API_URI + Uris.COMPETITION + "/" + competitionId);
		update();
	}

}
