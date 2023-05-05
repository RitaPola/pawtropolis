package pawtropoliss.domain.animal;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Tiger extends Animal{

	private Double tailLength;

	private Tiger(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height, Double tailLength) {
		super(name, favoriteFood, admissionDate, weight, height);
		this.tailLength=tailLength;
	}
	@Override
	public String toString() {
		return "Tiger: Name = " + getName() + ", Tail Length =  " +  tailLength + ", Favorite Food = " + getFavoriteFood()
				+ ", Admission Date = " + getAdmissionDate() + ", Weight = " + getWeight() + ", Height = "
				+ getHeight();
	}
}
