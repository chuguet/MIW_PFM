package es.upm.miw.pwitter.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Competition {

	public Competition() {

	}

	public Competition(List<Match> matchs, String name, Country country,
			Sport sport) {
		super();
		this.matchs = matchs;
		this.name = name;
		this.country = country;
		this.sport = sport;
	}

	private List<Match> matchs;

	private String name;

	private Country country;

	private Sport sport;

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sport == null) ? 0 : sport.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competition other = (Competition) obj;
		if (country != other.country)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sport != other.sport)
			return false;
		return true;
	}

	public void addMatch(Match match) {
		if (this.matchs == null) {
			this.matchs = new ArrayList<Match>();
		}
		this.matchs.add(match);
	}

}
