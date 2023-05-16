package com.project.pawtropoliss.zoo;

import com.project.pawtropoliss.zoo.domain.Animal;
import com.project.pawtropoliss.zoo.domain.Eagle;
import com.project.pawtropoliss.zoo.domain.Lion;
import com.project.pawtropoliss.zoo.domain.Tiger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
@Setter
@ToString
public class ZooController {
	private List <Lion> lions;
	private List <Tiger> tigers;
	private List <Eagle> eagles;
	private List <Animal> animals;

	public ZooController() {
		lions = new ArrayList <>();
		tigers= new ArrayList<>();
		eagles = new ArrayList<>();
		animals = new ArrayList <> ();
	}
	public void addLion(Lion lion) {lions.add(lion);}
	public void addTiger(Tiger tiger) {
		tigers.add(tiger);
	}
	public void addEagle( Eagle eagle) {
		eagles.add(eagle);
	}
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	//verifica l'altezza della specie Leoni
	public List <Lion> tallestShortestLion() {
		Optional<Lion> tallestLion = lions.stream()
				.max(Comparator.comparing(Lion::getHeight));
		Optional<Lion> shortestLion = lions.stream()
				.min(Comparator.comparing(Lion::getHeight));
		return Stream.concat(tallestLion.stream(), shortestLion.stream())
				.toList();
	}
	//verifica l'altezza della specie Tigri
	public List <Tiger> tallestShortestTiger(){
		Optional<Tiger> tallestTiger = tigers.stream()
				.max(Comparator.comparing(Tiger::getHeight));
		Optional<Tiger> shortestTiger = tigers.stream()
				.min(Comparator.comparing(Tiger::getHeight));
		return Stream.concat(tallestTiger.stream(), shortestTiger.stream())
				.toList();

	}
	//verifica l'altezza della specie Aquile
	public List <Eagle> tallestShortestEagle(){
		Optional<Eagle> tallestEagle = eagles.stream()
				.max(Comparator.comparing(Eagle::getHeight));
		Optional<Eagle> shortestEagle = eagles.stream()
				.min(Comparator.comparing(Eagle::getHeight));
		return Stream.concat(tallestEagle.stream(), shortestEagle.stream())
				.toList();
	}
	//verifica il peso della specie Leoni
	public List <Lion> heaviestlightestLion() {
		Optional<Lion> heaviestLion = lions.stream()
				.max(Comparator.comparing(Lion::getWeight));
		Optional<Lion> lightestLion = lions.stream()
				.min(Comparator.comparing(Lion::getWeight));
		return Stream.concat(heaviestLion.stream(), lightestLion.stream())
				.toList();
	}
	//verifica il peso della specie Tigri
	public List <Tiger> heaviestlightestTiger() {
		Optional<Tiger> heaviestTiger = tigers.stream()
				.max(Comparator.comparing(Tiger::getWeight));
		Optional<Tiger> lightestTiger = tigers.stream()
				.min(Comparator.comparing(Tiger::getWeight));
		return Stream.concat(heaviestTiger.stream(), lightestTiger.stream())
				.toList();
	}
	//verifica il peso della specie Aquile
	public List <Eagle> heaviestlightestEagle() {
		Optional<Eagle> heaviestHeagle = eagles.stream()
				.max(Comparator.comparing(Eagle::getWeight));
		Optional<Eagle> lightestHeagle = eagles.stream()
				.min(Comparator.comparing(Eagle::getWeight));
		return Stream.concat(heaviestHeagle.stream(), lightestHeagle.stream())
				.toList();
	}
	//lunghezza coda degli animali dotati di coda
	public Animal longestTail(){
		Optional<Animal> longestTail = animals.stream()
				.filter(animal -> animal instanceof Lion || animal instanceof Tiger)
				.max(Comparator.comparingDouble(animal -> {
					if (animal instanceof Lion) {
						return ((Lion) animal).getTailLength();
					} else {
						return ((Tiger) animal).getTailLength();
					}
				}));
		return longestTail.orElse(null);
	}
	//lunghezza ali aquile
	public Eagle longestWings() {
		Optional<Eagle> longestWingsEagle = eagles.stream()
				.max(Comparator.comparingDouble(Eagle::getWingsLength));

		return longestWingsEagle.orElse(null);
	}

}
