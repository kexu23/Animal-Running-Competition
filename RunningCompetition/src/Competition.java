import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Competition {

	private List<Animal> animals;         // A list containing all animals in the competition
	private Map<Animal, Integer> scoring; // For each animal, contains the discrete time units required for reaching the goal
	private final double COURSE_LENGTH;   // The length of the course
	private Random rng;                   // The random number generator to be used
	
	public List<Animal> getAnimals() {
		return animals;
	}
	
	public void setAnimals(List<Animal> anims) {
		animals = anims;
	}
	
	public Map<Animal, Integer> getScoring() {
		return scoring;
	}
	
	public void setScoring(Map<Animal, Integer> sc) {
		scoring = sc;
	}
	
	public void setRNG(Random rand) {
		rng = rand;
	}
	
	/** Use this constructor when you want everything set to default
	 * 
	 */
	public Competition() {
		this(new Random());
	}
	
	/** Use this constructor when you want the default course length, and
	 * when you want to control the random number generator
	 * @param random the random number generator to use in the application
	 */
	public Competition(Random random) {
		this(100.0, random);
	}
	
	
	/** Use this constructor when you want to specify the length of 
	 * the course yourself
	 * @param courseLength the length of the course
	 * @param random the random number generator to use in the application
	 */
	public Competition(double courseLength, Random random) {
		animals = new ArrayList<>();
		scoring = new HashMap<>();
		COURSE_LENGTH = courseLength;
		rng = random;
	}
	
	/** This method should create objects for all the different animals
	 * and then put them into the list of animals (the list is found
	 * among the instance variables).
	 * 
	 * Each animal must be initialised with the random number generator
	 * rng (the instance variable). E.g. a lion must be created like this:
	 * 
	 * new Lion(rng);
	 */
	public void initializeCompetition() {

		Cat Cat1 = new Cat(rng);
		Dog Dog1 = new Dog(rng);
		Hippo Hippo1 = new Hippo(rng);
		Lion lion1 = new Lion(rng);
		Panther Panther1 = new Panther(rng);
		Rabbit Rabbit1 = new Rabbit(rng);

		animals.add(Cat1);

		animals.add(Dog1);

		animals.add(Hippo1);
		
		animals.add(lion1);

		animals.add(Panther1);

		animals.add(Rabbit1);


		/*
		 * When creating the animals, make sure to pass the instance variable
		 * rng as argument to the constructors of the animals
		 * 
		 * You must add the animals to the list in the following order:
		 * 
		 * Cat, Dog, Hippo, Lion, Panther, Rabbit
		 */
		
	}
	
	

	/** When invoked, this method will start the competition.
	 * The animals should run through the course in turns, one
	 * by one. Time is discretized into units, such that during
	 * each discrete time unit, each animal will either stop 
	 * (with an animal specific probability) to eat, or run towards
	 * the goal with a speed that varies randomly within an 
	 * animal specific interval. See the task description for
	 * the animal specific probabilities and speeds. 
	 * 
	 * Upon completion, the method should return a List containing 
	 * the animal(s) that finished the competition in the fewest time 
	 * units. Keep in mind that several animals may complete the 
	 * competition in an equal amount of time units, thus sharing 
	 * the first place. Should that happen, the returned list should
	 * contain all those animals that finished the competition in an
	 * equal amount of time units.
	 * 
	 * @return a List containing all animals that completed the 
	 * competition in the fewest time units
	 */
	public List<Animal> go() {
		ArrayList<Animal> race = new ArrayList<Animal>();
		for (int i = 0; i < animals.size(); i++) {
			runAnimal(animals.get(i));
			race.add(animals.get(i));
		}
		displayRatings();
		System.out.println(race);
		return race;
	}
	
	/** This method shall handle the competition for one animal. The 
	 * animal shall run forward until it reaches the end of the course. 
	 * During each discrete time unit, the animal will run forward with
	 * an animal specific speed that varies randomly within an interval.
	 * However, with an animal specific probability, the animal may
	 * stop for one time unit to eat. While eating, the animal will not
	 * move forward.
	 *  
	 * The method should measure the discrete time required for the animal
	 * to reach the goal. The discrete time required should be stored
	 * in the scoring Map (the instance variable). 
	 * 
	 * @param anim the animal that is going to run
	 * @return the number of time units before the animal reached the goal
	 */
	public int runAnimal(Animal anim) {

		int timeUnits = 0;

			while (anim.getDistanceTravelled() < COURSE_LENGTH) {

				if (anim.willRun()) {
					anim.run();
					timeUnits = timeUnits+1;
				}

				else {
					timeUnits = timeUnits+1;
				}
			}
		
		scoring.put(anim, timeUnits);	
		return timeUnits;
	}
	
	/** This method shall display a table in the console, containing 
	 * each animal and the time units it took the animal to complete
	 * the competition
	 * 
	 */
	public void displayRatings() {

		System.out.println("Cat " + runAnimal(animals.get(0)));
		System.out.println("Dog " + runAnimal(animals.get(1)));
		System.out.println("Hippo " + runAnimal(animals.get(2)));
		System.out.println("Lion " + runAnimal(animals.get(3)));
		System.out.println("Panther " + runAnimal(animals.get(4)));
		System.out.println("Rabbit " + runAnimal(animals.get(5)));
		
	}
	
	
	/** This method shall return a sorted List of animals, where
	 * the animals are sorted based on the time it took for them 
	 * to reach the goal in the competition. The returned list should 
	 * be sorted such that the animal that completed the competition
	 * in the shortest time, should be at the first index in the list.
	 * The slowest animal should be last in the list. The instance variable
	 * Map scoring should contain the time required by each animal to reach
	 * the goal, and it should be used as basis for the sorting.
	 * 
	 * HINT: You can access the keys in the scoring Map with the 
	 * method keySet() found in the interface Map. E.g. the code
	 * scoring.keySet() will give you a Set containing all the keys found
	 * in the map. 
	 * 
	 * NOTE: This method is a bit tricky to implement. You will need to
	 * figure out how to implement sorting of elements. I suggest that you
	 * implement the algorithm insertion sort (google it), but there are many
	 * other viable alternatives also. 
	 * 
	 * @return a sorted List of animals, based on the time it took for
	 * them to finish the competition
	 */
	public List<Animal> getPlacings(){

		int mintime = scoring.get(animals.get(0));
		int item = 0;
		int temp;

		ArrayList<Animal> race = new ArrayList<Animal>();
		for (int i = 0; i < animals.size(); i++) {
			for (int e = 0; e < animals.size(); e++) {
				temp = scoring.get(animals.get(e));
				mintime = temp;
				item = e;
				
			}
			if (item == animals.size()-1) {
				race.add(animals.get(item));
				scoring.put(animals.get(item), 10000);
				mintime = 10000;
			}
		}
		
		return race;
	}

}