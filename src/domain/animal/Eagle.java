package domain.animal;

import java.time.LocalDate;

public class Eagle extends Animal {

	private Double wingsLength;

	public Eagle(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height, Double wingsLength) {
		super(name, favoriteFood, admissionDate, weight, height);
		this.wingsLength=wingsLength;
	}

	public Double getWingsLength() {
		return wingsLength;
	}

	public void setWingsLength(Double wingsLength) {
		this.wingsLength = wingsLength;
	}

	@Override
	public String toString() {
		return "Eagle: Name = " + getName() + ",  Wings length = " + wingsLength  + ", Favorite Food = " + getFavoriteFood()
		+ ", Admission Date = " + getAdmissionDate() + ", Weight = " + getWeight() + ", Height = "
		+ getHeight();
	}

	

	

}
