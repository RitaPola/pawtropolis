package gestionezoo;

public abstract class Animal {
	private String name;
	private String favoriteFood;
	private Integer admissionYear;
	private Double weight;
	private Double height;

	public Animal(String name, String favoriteFood, Integer admissionYear, Double weight, Double height) {
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.admissionYear = admissionYear;
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

	public Integer getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionDate(Integer admissionYear) {
		this.admissionYear = admissionYear;
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
		return "Animal: Name=" + name + ", Favorite Food=" + favoriteFood + ", Admission Date=" + admissionYear + ", Weight=" + weight
				+ ", Height=" + height;
	}
}
