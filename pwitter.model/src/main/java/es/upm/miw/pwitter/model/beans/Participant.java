package es.upm.miw.pwitter.model.beans;

public class Participant {

	private Country country;

	private String name;

	public Participant() {
	}

	public Participant(String name, Country country) {
		super();
		this.country = country;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		if (country != other.country)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Country getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setName(String name) {
		this.name = name;
	}

}
