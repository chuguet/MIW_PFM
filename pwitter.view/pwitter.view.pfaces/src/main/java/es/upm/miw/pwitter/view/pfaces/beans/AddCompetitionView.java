package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Message;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@Named
@Scope("session")
public class AddCompetitionView extends AbstractCompetitionView implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private Competition competition;

	@PostConstruct
	public void init() {
		competition = new Competition();
	}

	public String process() {
		this.restClient.postForObject(API_URI + Uris.COMPETITION, competition,
				Message.class);
		return null;
	}

}
