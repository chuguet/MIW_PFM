package es.upm.miw.pwitter.model.exceptions;

public abstract class CompetitionException extends RuntimeException {

	private static final long serialVersionUID = 3183130369160307080L;

	public CompetitionException(String message) {
		super(message);
	}

}
