package com.revature.JavaDoodleDuels.web.dto;

import java.util.List;
import java.util.Objects;

import com.revature.JavaDoodleDuels.models.Dueler;

public class HomePageResponse {

	List<Dueler> randomDuelers;

	public HomePageResponse() {
		super();
	}

	public HomePageResponse(List<Dueler> randomDuelers) {
		super();
		this.randomDuelers = randomDuelers;
	}

	public List<Dueler> getRandomDuelers() {
		return randomDuelers;
	}

	public void setRandomDuelers(List<Dueler> randomDuelers) {
		this.randomDuelers = randomDuelers;
	}

	@Override
	public String toString() {
		return "HomePageResponse [randomDuelers=" + randomDuelers + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(randomDuelers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HomePageResponse other = (HomePageResponse) obj;
		return Objects.equals(randomDuelers, other.randomDuelers);
	}
}
