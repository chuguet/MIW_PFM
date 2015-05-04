package es.upm.miw.pwitter.model.beans;

import java.util.Date;

public class Match {

	public Match() {
	}

	public Match(Participant local, Participant visitor, Date date,
			Result result) {
		super();
		this.local = local;
		this.visitor = visitor;
		this.date = date;
		this.result = result;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((visitor == null) ? 0 : visitor.hashCode());
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (result != other.result)
			return false;
		if (visitor == null) {
			if (other.visitor != null)
				return false;
		} else if (!visitor.equals(other.visitor))
			return false;
		return true;
	}

}
