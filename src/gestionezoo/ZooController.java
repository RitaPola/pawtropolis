package gestionezoo;

import java.time.LocalDate;

public class ZooController {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		Lion lion1 = new Lion("Simba","carne cruda di zebra", LocalDate.now(), 300.00, 1.75,3.00);
		Lion lion2 = new Lion("Nala","carne",LocalDate.now(), 250.00, 1.50,5.00);
		Lion lion3 = new Lion("Leone","carne cruda di antilope",LocalDate.now(), 350.00, 1.75,4.00);
		Lion lion4 = new Lion("Leone2","carne cruda di antilope",LocalDate.now(), 350.00, 1.75,4.00);
		Lion lion5 = new Lion("Nala2","carne",LocalDate.now(), 250.00, 1.50,5.00);
		zoo.addAnimals(lion1);
		System.out.println(lion1);
		zoo.addAnimals(lion2);
		zoo.addAnimals(lion3);
		zoo.addAnimals(lion4);
		zoo.addAnimals(lion5);
		System.out.println("Gli animali all'interno dello zoo sono: " + zoo);
		System.out.println("Il leone più alto è " + zoo.tallest("Lion"));
		System.out.println("Il leone più basso è " + zoo.shortest("Lion"));
		System.out.println("Il leone più grasso è " + zoo.fattest("Lion"));
		System.out.println("Il leone più magro è " + zoo.slimmest("Lion"));
		
		/*Tiger tiger1 = new Tiger("Tigre1","carne",2002, 200.00, 1.60,6.00);
		Tiger tiger2 = new Tiger("Tigre2","carne",2003, 300.00, 1.90,7.00);
		Tiger tiger3 = new Tiger("Tigre3","carne",2004, 400.00, 1.30,8.00);
		Tiger tiger4 = new Tiger("Tigre4","carne",2004, 400.00, 1.30,8.00);
		zoo.addAnimals(tiger1);
		zoo.addAnimals(tiger2);
		zoo.addAnimals(tiger3);
		zoo.addAnimals(tiger4);
		System.out.println("Gli animali all'interno dello zoo sono: " + zoo);
		System.out.println("La tigre più alta è " + zoo.tallest("Tiger"));
		System.out.println("La tigre più bassa è " + zoo.shortest("Tiger"));
		System.out.println("La Tigre più grassa è " + zoo.fattest("Tiger"));
		System.out.println("La Tigre più magra è " + zoo.slimmest("Tiger"));
		System.out.println("La coda più lunga " + zoo.tails());
		
		Eagle eagle1 = new Eagle("Eagle1","carne",2001, 50.00, 1.20,10.00);
		Eagle eagle2 = new Eagle("Eagle2","carne",2002, 45.00, 1.10,11.00);
		Eagle eagle3 = new Eagle("Eagle3","carne",2003, 55.00, 1.05,12.00);
		Eagle eagle4 = new Eagle("Eagle4","carne",2003, 55.00, 1.05,12.00);
		zoo.addAnimals(eagle1);
		zoo.addAnimals(eagle2);
		zoo.addAnimals(eagle3);
		zoo.addAnimals(eagle4);
		System.out.println("Gli animali all'interno dello zoo sono: " + zoo);
		System.out.println("L'aquila più alta è " + zoo.tallest("Eagle"));
		System.out.println("L'aquila più bassa è " + zoo.shortest("Eagle"));
		System.out.println("L'aquila più grassa è " + zoo.fattest("Eagle"));
		System.out.println("L'aquila più magra è " + zoo.slimmest("Eagle"));
		System.out.println("L'aquila con l'apertura alare più grande " + zoo.wings());
		
		System.out.println("Gli animali più alti sono " + zoo.tallestAll());
		System.out.println("Gli animali più bassi sono " + zoo.shortestAll());
		System.out.println("Gli animali più grassi sono " + zoo.fattestAll());
		System.out.println("Gli animali più magri sono " + zoo.slimmestAll());*/
		
		
		
//		Scanner input = new Scanner(System.in);
//		String name, favoriteFood;
		//		Integer admissionYear; 
		//		Double weigth, eight, tailLength, wingsLength;
		//		try {
		//			for(int x = 0; x<3; x++) {
		//				System.out.println("Inserisci il nome del leone");
		//				name = input.next();
		//				System.out.println("Inserisci il cibo preferito del leone");
		//				favoriteFood = input.next();
		//				System.out.println("Inserisci l'anno di ammissione del leone nello zoo");
		//				admissionYear = input.nextInt();
		//				System.out.println("Inserisci l'altezza del leone");
		//				eight = input.nextDouble();
		//				System.out.println("Inserisci il peso del leone");
		//				weigth = input.nextDouble();
		//				System.out.println("Inserisci la lunghezza della coda del leone");
		//				tailLength = input.nextDouble();
		//				Lion lion = new Lion(name,favoriteFood,admissionYear,weigth,eight,tailLength);
		//				zoo.addAnimals(lion);
		//			}
		//		}catch(InputMismatchException e) {
		//			System.out.println("Input errato! riprova");
		//		}
		//		System.out.println("Il leone più basso è " + zoo.shortest("Lion"));
		//		System.out.println("Il leone più grasso e più magro è " + zoo.fatSlim("Lion"));
		//		Tiger tiger1 = new Tiger("Tigre1","carne",2002, 200.00, 1.60,6.00);
		//		Tiger tiger2 = new Tiger("Tigre2","carne",2003, 300.00, 1.90,7.00);
		//		Tiger tiger3 = new Tiger("Tigre3","carne",2004, 400.00, 1.30,8.00);
		//
		//		zoo.addAnimals(tiger1);
		//		zoo.addAnimals(tiger2);
		//		zoo.addAnimals(tiger3);
		//		try {
		//			for(int x = 0; x<2; x++) {
		//				System.out.println("Inserisci il nome delle tigri");
		//				name = input.next();
		//				System.out.println("Inserisci il cibo preferito della tigre");
		//				favoriteFood = input.next();
		//				System.out.println("Inserisci l'anno di ammissione della tigre nello zoo");
		//				admissionYear = input.nextInt();
		//				System.out.println("Inserisci l'altezza della tigre");
		//				eight = input.nextDouble();
		//				System.out.println("Inserisci il peso della tigre");
		//				weigth = input.nextDouble();
		//				System.out.println("Inserisci la lunghezza della coda della tigre");
		//				tailLength = input.nextDouble();
		//				Tiger tiger = new Tiger(name,favoriteFood,admissionYear,weigth,eight,tailLength);
		//				zoo.addAnimals(tiger);
		//			}
		//		}catch(InputMismatchException e) {
		//			System.out.println("Input errato! riprova");
		//		}
		//		System.out.println("Gli animali all'interno dello zoo sono: " + zoo);
		//		System.out.println("Le tigri più alte e più basse sono " + zoo.biggerSmaller("Tiger"));
		//		System.out.println("Le tigri più grasse e più magre sono " + zoo.fatSlim("Tiger"));
		//		System.out.println("L'animale con la coda più lunga è " + zoo.tail());
		//
		//
		//		try {
		//			for(int x = 0; x<2; x++) {
		//				System.out.println("Inserisci il nome dell' aquila ");
		//				name = input.next();
		//				System.out.println("Inserisci il cibo preferito dell' aquila ");
		//				favoriteFood = input.next();
		//				System.out.println("Inserisci l'anno di ammissione dell' aquila nello zoo");
		//				admissionYear = input.nextInt();
		//				System.out.println("Inserisci l'altezza dell' aquila ");
		//				eight = input.nextDouble();
		//				System.out.println("Inserisci il peso dell' aquila");
		//				weigth = input.nextDouble();
		//				System.out.println("Inserisci la lunghezza delle ali dell' aquila");
		//				wingsLength = input.nextDouble();
		//				Eagle eagle = new Eagle(name,favoriteFood,admissionYear,weigth,eight,wingsLength);
		//				zoo.addAnimals(eagle);
		//			}
		//		}catch(InputMismatchException e) {
		//			System.out.println("Input errato! riprova");
		//		}
		//		//		Eagle eagle1 = new Eagle("Eagle1","carne",2001, 50.00, 1.20,10.00);
		//		//		Eagle eagle2 = new Eagle("Eagle2","carne",2002, 45.00, 1.10,11.00);
		//		//		Eagle eagle3 = new Eagle("Eagle3","carne",2003, 55.00, 1.05,12.00);
		//
		//		//		zoo.addAnimals(eagle1);
		//		//		zoo.addAnimals(eagle2);
		//		//		zoo.addAnimals(eagle3);
		//		System.out.println("Gli animali all'interno dello zoo sono: " + zoo);
		//		System.out.println("Le aquile più grandi e più piccole sono: " + zoo.biggerSmaller("Eagle"));
		//		System.out.println("Le aquile più grasse e più magre sono " + zoo.fatSlim("Eagle"));
		//		System.out.println("L'aquila con la coda più lunga è: " + zoo.wings());
		//
		//		System.out.println("Gli animali più alti e più bassi sono: " + zoo.biggerSmallerAll());
		//		System.out.println("Gli animali più grassi e più magri sono: " + zoo.fatSlimAll());
	}

}
