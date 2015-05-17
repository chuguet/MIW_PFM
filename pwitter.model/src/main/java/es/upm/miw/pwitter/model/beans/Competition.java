package es.upm.miw.pwitter.model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Competition implements Serializable {

	public Competition() {

	}

	public Competition(Integer id) {
		this.id = id;
	}

	public Competition(Integer id, String name, Country country, Sport sport) {
		this(id);
		this.name = name;
		this.country = country;
		this.sport = sport;
	}

	public Competition(Integer id, List<Match> matchs, String name,
			Country country, Sport sport) {
		this(id, name, country, sport);
		this.matchs = matchs;
	}

	private Integer id;

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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void addMatch(Match match) {
		if (this.matchs == null) {
			this.matchs = new ArrayList<Match>();
		}
		this.matchs.add(match);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
