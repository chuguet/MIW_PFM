package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@ManagedBean
@ViewScoped
public class EditCompetitionBean extends AbstractCompetitionView implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{beanInitialView}")
	private ListCompetitionsView listCompetition;

	private Competition competition;

	public EditCompetitionBean() {
		super();
	}

	@PostConstruct
	public void update() {
		competition = listCompetition.getSelectedCompetition();
	}

	public void process() {
		restClient.put(API_URI + Uris.COMPETITION, competition);
	}

}
