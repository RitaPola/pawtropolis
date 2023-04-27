package pawtropoliss.domain.animal;

import java.time.LocalDate;

public class Animal {
	private String name;
	private String favoriteFood;
	private LocalDate admissionDate;
	private Double weight;
	private Double height;

	public Animal(String name, String favoriteFood, LocalDate admissionDate, Double weight, Double height) {
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.admissionDate = admissionDate;
		this.weight = weight;
		this.height = height;
	}

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

	@Override
	public String toString() {
		return "Animal: Name=" + name + ", Favorite Food=" + favoriteFood + ", Admission Date=" + admissionDate + ", Weight=" + weight
				+ ", Height=" + height;
	}
}
