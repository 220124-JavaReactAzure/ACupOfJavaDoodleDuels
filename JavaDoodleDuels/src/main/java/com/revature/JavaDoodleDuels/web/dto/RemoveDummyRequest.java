package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

public class RemoveDummyRequest {
	
	private String duelerName;

	public RemoveDummyRequest() {
		super();
	}

	public RemoveDummyRequest(String duelerName) {
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
		return "RemoveDummyRequest [duelerName=" + duelerName + "]";
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
		RemoveDummyRequest other = (RemoveDummyRequest) obj;
		return Objects.equals(duelerName, other.duelerName);
	}
	
}
