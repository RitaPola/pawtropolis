package pawtropoliss.domain.animal;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
public class Animal {
	private String name;
	private String favoriteFood;
	private LocalDate admissionDate;
	private Double weight;
	private Double height;

	@Override
	public String toString() {
		return "Animal: Name=" + name + ", Favorite Food=" + favoriteFood + ", Admission Date=" + admissionDate + ", Weight=" + weight
				+ ", Height=" + height;
	}

}
