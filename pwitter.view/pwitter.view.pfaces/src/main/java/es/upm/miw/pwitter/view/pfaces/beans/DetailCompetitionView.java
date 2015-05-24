package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.upm.miw.pwitter.model.beans.Competition;

@ManagedBean(name = "detailCompetition")
@ViewScoped
public class DetailCompetitionView extends AbstractCompetitionView implements
		Serializable {

	private final static Log LOG = LogFactory
			.getLog(DetailCompetitionView.class);

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{competitionList}")
	private ListCompetitionsView listCompetition;

	private Competition competition;

	public DetailCompetitionView() {
		super();
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public ListCompetitionsView getListCompetition() {
		return listCompetition;
	}

	public void setListCompetition(ListCompetitionsView listCompetition) {
		this.listCompetition = listCompetition;
	}

	@PostConstruct
	public void update() {
		LOG.info("Update Detail view");
		competition = listCompetition.getSelectedCompetition();
	}

}
