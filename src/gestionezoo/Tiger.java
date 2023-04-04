package gestionezoo;

public class Tiger extends Animal{

	private Double tailLength;

	public Tiger(String name, String favoriteFood, Integer admissionYear, Double weight, Double height,Double tailLength) {
		super(name, favoriteFood, admissionYear, weight, height);
		this.tailLength=tailLength;
	}

	public Double getTailLength() {
		return tailLength;
	}

	public void setTailLength(Double tailLength) {
		this.tailLength = tailLength;
	}

	@Override
	public String toString() {
		return "Tiger: Name = " + getName() + ", Tail Length =  " +  tailLength + ", Favorite Food = " + getFavoriteFood()
		+ ", Admission Year = " + getAdmissionYear() + ", Weight = " + getWeight() + ", Height = "
		+ getHeight();
	}

	

	
}
