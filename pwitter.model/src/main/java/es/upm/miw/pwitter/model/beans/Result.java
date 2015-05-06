package es.upm.miw.pwitter.model.beans;

public enum Result {

	VICTORIA_LOCAL("Victoria local"), EMPATE("Empate"), VICTORIA_VISITANTE(
			"Victoria visitante"), SIN_DISPUTAR("Sin disputar");

	private String nameId;

	private Result(String nameId) {
		this.nameId = nameId;
	}

	public String getNameId() {
		return this.nameId;
	}

	public String toString() {
		return this.getNameId();
	}

}
