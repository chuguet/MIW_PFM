package es.upm.miw.pwitter.model.beans;

public enum Country {

	ESPANA("España"), FRANCIA("Francia"), ITALIA("Italia"), ALEMANIA("Alemania"), INGLATERRA(
			"Inglaterra"), HOLANDA("Holanda"), BELGICA("Belgica"), POLONIA(
			"Polonia"), PORTUGAL("Portugal");

	private String nameId;

	private Country(String nameId) {
		this.nameId = nameId;
	}

	public String getNameId() {
		return this.nameId;
	}

	public String toString() {
		return this.getNameId();
	}

}
