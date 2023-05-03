package pawtropoliss.domain.animal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Eagle extends Animal {

	private Double wingsLength;

	private Eagle(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height, Double wingsLength) {
		super(name, favoriteFood, admissionDate, weight, height);
		this.wingsLength = wingsLength;
	}
}
