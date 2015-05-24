package es.upm.miw.pwitter.view.pfaces.beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.upm.miw.pwitter.model.beans.Country;
import es.upm.miw.pwitter.model.beans.Result;
import es.upm.miw.pwitter.model.beans.Sport;
import es.upm.miw.pwitter.rest.core.uris.Uris;

@ManagedBean(name = "data")
@ApplicationScoped
public class DataBean extends AbstractCompetitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	public Sport[] getSports() {
		return restClient.getForObject(API_URI + Uris.SPORTS, Sport[].class);
	}

	public Country[] getCountries() {
		return restClient.getForObject(API_URI + Uris.COUNTRIES,
				Country[].class);
	}

	public Result[] getResults() {
		return restClient.getForObject(API_URI + Uris.RESULTS, Result[].class);
	}

}
