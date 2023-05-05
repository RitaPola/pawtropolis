package pawtropoliss.domain.animal;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class Eagle extends Animal {

	private Double wingsLength;

	private Eagle(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height, Double wingsLength) {
		super(name, favoriteFood, admissionDate, weight, height);
		this.wingsLength = wingsLength;
	}
	public String toString() {
		return "Eagle: Name = " + getName() + ",  Wings length = " + wingsLength  + ", Favorite Food = " + getFavoriteFood()
				+ ", Admission Date = " + getAdmissionDate() + ", Weight = " + getWeight() + ", Height = "
				+ getHeight();
	}
}
