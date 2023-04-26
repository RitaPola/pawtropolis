package controller.zoo;

import domain.animal.Animal;
import domain.animal.Eagle;
import domain.animal.Lion;
import domain.animal.Tiger;

import java.util.ArrayList;
import java.util.List;

public class ZooController {

	private List <Animal> animals;

	public ZooController() {
		animals = new ArrayList <> (); 
	}

	public ZooController(ArrayList<Animal> animals) {
		this.animals = animals;
	}
	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
	@Override
	public String toString() {
		return "Zoo: animals=" + animals;
	}

	public void addAnimals(Animal animal) {

		animals.add(animal);
	}

	public ArrayList <Animal> tallest(String animal) {
		
		ArrayList <Animal> speciesTallest = new ArrayList <>();
		Animal tallest = null;
		for (Animal anim : animals) {
			if(anim.getClass().getName().equals("gestionezoo." + animal)) { /*confrontare il nome della classe con la stringa passata*/
				if (tallest==null || anim.getHeight() > tallest.getHeight()) {
					speciesTallest.clear();
					tallest=anim;
					speciesTallest.add(tallest);
				}else if(anim.getHeight().equals(tallest.getHeight())) {
					speciesTallest.add(anim);
			}
			}
		}
		return speciesTallest;
	}
	public ArrayList <Animal> shortest(String animal) {
		ArrayList <Animal> speciesShortest = new ArrayList <>();
		Animal shortest = null;
		for (Animal anim : animals) {
			if(anim.getClass().getName().equals("gestionezoo." + animal)) { /*confrontare il nome della classe con la stringa passata*/
				if (shortest==null || anim.getHeight() < shortest.getHeight()) {
					speciesShortest.clear();
					shortest=anim;
					speciesShortest.add(shortest);
				}else if(anim.getHeight().equals(shortest.getHeight())) {
					speciesShortest.add(anim);
			}
			}
		}
		return speciesShortest;
	}

	/*controllo altezza tra tutti gli animali all'interno dell'arrayList*/
	public ArrayList <Animal> tallestAll() {
		ArrayList <Animal> speciesTallest = new ArrayList <>();
		Animal tallest = null;
		for (Animal anim : animals) {
				if (tallest==null || anim.getHeight() > tallest.getHeight()) {
					speciesTallest.clear();
					tallest=anim;
					speciesTallest.add(tallest);
				}else if(anim.getHeight().equals(tallest.getHeight())) {
					speciesTallest.add(anim);
			}
		}
		return speciesTallest;
	}
	public ArrayList <Animal> shortestAll() {
		ArrayList <Animal> speciesShortest = new ArrayList <>();
		Animal shortest = null;
		for (Animal anim : animals) {
				if (shortest==null || anim.getHeight() < shortest.getHeight()) {
					speciesShortest.clear();
					shortest=anim;
					speciesShortest.add(shortest);
				}else if(anim.getHeight().equals(shortest.getHeight())) {
					speciesShortest.add(anim);
			}
		}
		return speciesShortest;
	}

	public ArrayList <Animal> fattest(String animal) {
		ArrayList <Animal> speciesFattest = new ArrayList <>();
		Animal fat = null;
		for (Animal anim : animals) {
			if(anim.getClass().getName().equals("gestionezoo." + animal)) { /*confrontare il nome della classe con la stringa passata*/
				if (fat==null || anim.getWeight() > fat.getWeight()) {
					speciesFattest.clear();
					fat=anim;
					speciesFattest.add(fat);
				}else if(anim.getWeight().equals(fat.getWeight())) {
					speciesFattest.add(anim);
			}
			}
		}
		return speciesFattest;
	}
	public ArrayList <Animal> slimmest(String animal) {
		ArrayList <Animal> speciesSlimmest = new ArrayList <>();
		Animal slim = null;
		for (Animal anim : animals) {
			if(anim.getClass().getName().equals("gestionezoo." + animal)) { /*confrontare il nome della classe con la stringa passata*/
				if (slim==null || anim.getWeight() < slim.getWeight()) {
					speciesSlimmest.clear();
					slim=anim;
					speciesSlimmest.add(slim);
				}else if(anim.getWeight().equals(slim.getWeight())) {
					speciesSlimmest.add(anim);
			}
			}
		}
		return speciesSlimmest;
	}
	/*controllo animale più pesante più leggero tra tutti gli animali dell'arrayList*/
	public ArrayList <Animal> fattestAll() {
		ArrayList <Animal> speciesFattest = new ArrayList <>();
		Animal fat = null;
		for (Animal anim : animals) {
				if (fat==null || anim.getWeight() > fat.getWeight()) {
					speciesFattest.clear();
					fat=anim;
					speciesFattest.add(fat);
				}else if(anim.getWeight().equals(fat.getWeight())) {
					speciesFattest.add(anim);
			}
		}
		return speciesFattest;
	}
	public ArrayList <Animal> slimmestAll() {
		ArrayList <Animal> speciesSlimmest = new ArrayList <>();
		Animal slim = null;
		for (Animal anim : animals) {
				if (slim==null || anim.getWeight() < slim.getWeight()) {
					speciesSlimmest.clear();
					slim=anim;
					speciesSlimmest.add(slim);
				}else if(anim.getWeight().equals(slim.getWeight())) {
					speciesSlimmest.add(anim);
			}
		}
		return speciesSlimmest;
	}

	public Animal tails() {
		Double tailsAnimals = 0.0;
		Animal longestTail = null; 
		for(Animal anim : animals) {
			if(anim.getClass().getName().equals("gestionezoo.Lion")) {
				Lion lion = (Lion) anim;
				if(lion.getTailLength()>tailsAnimals) {
					tailsAnimals = lion.getTailLength(); 
					longestTail = lion; 
				}
			}
			if(anim.getClass().getName().equals("gestionezoo.Tiger")) {
				Tiger tiger = (Tiger) anim;
				if(tiger.getTailLength()>tailsAnimals) {
					tailsAnimals = tiger.getTailLength(); 
					longestTail = tiger; 
				}
			}
		}
		return longestTail;  
	}
	
	public ArrayList <Animal> wings() {
		ArrayList <Animal> lengthWings = new ArrayList <>();
		Eagle longestWings = null;
		for(Animal anim : animals) {
			if( anim.getClass().getName().equals("gestionezoo.Eagle")) {
				Eagle eagle = (Eagle) anim;
				if(longestWings==null || eagle.getWingsLength() > longestWings.getWingsLength()) {
					lengthWings.clear();
					longestWings = eagle; 
					lengthWings.add(longestWings);
				}else if(eagle.getWingsLength().equals(longestWings.getWingsLength())) {
					lengthWings.add(eagle);
				}
			}
		}
		return lengthWings; 
	}

}
