package gestionezoo;

public class Lion extends Animal {
private Double tailLength;

public Lion(String name, String favoriteFood, Integer admissionYear, Double weight, Double height, Double tailLength) {
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
	return "Lion  Name = " + getName()  + ", Tail Length =" + tailLength + ", Preferite Food = " + getFavoriteFood()
	+ ", Admission Year = " + getAdmissionYear() + ", Weight = " + getWeight() + ", Height = "
	+ getHeight();
}


}

