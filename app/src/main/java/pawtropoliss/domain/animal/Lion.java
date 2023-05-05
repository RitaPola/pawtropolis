package pawtropoliss.domain.animal;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
public class Lion extends Animal {
	private Double tailLength;

	public Lion(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height, Double tailLength) {
		super(name, favoriteFood, admissionDate, weight, height);
		this.tailLength = tailLength;
	}
	@Override
	public String toString() {
		return "Lion  Name = " + getName()  + ", Tail Length =" + tailLength + ", Preferite Food = " + getFavoriteFood()
				+ ", Admission Date = " + getAdmissionDate() + ", Weight = " + getWeight() + ", Height = "
				+ getHeight();
	}
}
