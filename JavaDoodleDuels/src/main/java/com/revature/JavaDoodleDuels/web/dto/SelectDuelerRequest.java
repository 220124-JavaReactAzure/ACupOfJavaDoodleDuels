package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

public class SelectDuelerRequest {
	
	private String duelerName;

	public SelectDuelerRequest() {
		super();
	}

	public SelectDuelerRequest(String duelerName) {
		super();
		this.duelerName = duelerName;
	}

	public String getDuelerName() {
		return duelerName;
	}

	public void setDuelerName(String duelerName) {
		this.duelerName = duelerName;
	}

	@Override
	public String toString() {
		return "SelectDuelerRequest [duelerName=" + duelerName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(duelerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectDuelerRequest other = (SelectDuelerRequest) obj;
		return Objects.equals(duelerName, other.duelerName);
	}

}
