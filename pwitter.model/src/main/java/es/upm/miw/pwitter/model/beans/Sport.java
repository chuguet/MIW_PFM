package es.upm.miw.pwitter.model.beans;

public enum Sport {

	FUTBOL("Futbol"), BALONCESTO("Baloncesto"), BALONMANO("Balonmano");

	private String nameId;

	private Sport(String nameId) {
		this.nameId = nameId;
	}

	public String getNameId() {
		return this.nameId;
	}

	public String toString() {
		return this.getNameId();
	}

}
