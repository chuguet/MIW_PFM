package es.upm.miw.pwitter.model.beans;

import java.util.Date;

public class Match {

	public Match() {
	}

	public Match(Integer id, Participant local, Participant visitor, Date date,
			Result result) {
		super();
		this.id = id;
		this.local = local;
		this.visitor = visitor;
		this.date = date;
		this.result = result;
	}

	private Integer id;

	private Participant local;

	private Participant visitor;

	private Date date;

	private Result result;

	public Participant getLocal() {
		return local;
	}

	public void setLocal(Participant local) {
		this.local = local;
	}

	public Participant getVisitor() {
		return visitor;
	}

	public void setVisitor(Participant visitor) {
		this.visitor = visitor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Match other = (Match) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
