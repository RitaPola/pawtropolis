package gestionezoo;

public class Eagle extends Animal {

	private Double wingsLength;

	public Eagle(String name, String favoriteFood, Integer admissionYear, Double weight, Double height,Double wingsLength) {
		super(name, favoriteFood, admissionYear, weight, height);
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
		+ ", Admission Year = " + getAdmissionYear() + ", Weight = " + getWeight() + ", Height = "
		+ getHeight();
	}

	

	

}
