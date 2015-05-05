package es.upm.miw.pwitter.model.beans;

public class Message {

	public Message(String mensaje, Boolean correcto) {
		this.mensaje = mensaje;
		this.correcto = correcto;
	}

	private String mensaje;

	private Boolean correcto;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getCorrecto() {
		return correcto;
	}

	public void setCorrecto(Boolean correcto) {
		this.correcto = correcto;
	}

}
