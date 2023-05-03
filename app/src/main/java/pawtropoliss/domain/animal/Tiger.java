package pawtropoliss.domain.animal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Tiger extends Animal{

	private Double tailLength;

	private Tiger(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height, Double tailLength) {
		super(name, favoriteFood, admissionDate, weight, height);
		this.tailLength=tailLength;
	}
}
