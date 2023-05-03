package pawtropoliss.domain.animal;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Animal {
	private String name;
	private String favoriteFood;
	private LocalDate admissionDate;
	private Double weight;
	private Double height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

}
