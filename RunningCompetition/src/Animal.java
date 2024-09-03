import java.util.Random;


public abstract class Animal {

	/*
	 * 
	 * NOTE! The reference variable rng MUST refer to the 
	 * same random number generator that is used in the 
	 * class Competition
	 * 
	 */
	private Random rng;
	
	
	/**The constructor for the Animal. Do not modify.
	 * @param random the random number generator which MUST
	 * be the same as the one used in the class Competition
	 */
	public Animal(Random random) {
		rng = random;
    }
	
	
	/**This method shall move the animal forward with a
	 * distance and random variation that is specific to 
	 * each type of animal. 
	 * 
	 * NOTE: You MUST use the method nextDouble in the class
	 * Random for getting the random numbers
	 */
	public abstract void run();
	
	/**This method shall randomly return true or false, where
	 * the probabilities of true and false are animal specific.
	 * If the method returns true, it means that the animal should
	 * move forward. If it returns false, it means that the animal 
	 * should not move forward (because it stops and eats)
	 * 
	 * NOTE: You MUST use the method nextDouble in the class
	 * Random for getting the random numbers
	 * 
	 * @return true if animal should move forward, otherwise false
	 */
	public abstract boolean willRun();
	
	/**This method shall return the distance that the animal
	 * has run so far
	 * 
	 * @return a double representing the distance that the animal
	 * has run so far
	 */
    public abstract double getDistanceTravelled();
    
    public Random getRNG() {
        return rng;
    }
}

class Lion extends Animal  {

    double runniBoi;

    public Lion(Random random) {
        super(random);
    }
    
    public void run() {
        double x = 3.5 + (4.5 - 3.5) * getRNG().nextDouble();
        runniBoi += x;
    }

    public double getDistanceTravelled() {
        return runniBoi;
    }

    public boolean willRun() {
        if(getRNG().nextDouble() <=0.13) {
            return false;
        }
        return true;
    }
}

class Panther extends Animal  {

	double runniBoi;
	
	Random r = new Random();

    public Panther(Random random) {
        super(random);
    }
    
    public void run() {
        double x = 3.7 + (5.3 - 3.7) * getRNG().nextDouble();
        runniBoi += x;
    }

    public double getDistanceTravelled() {
        return runniBoi;
    }

    public boolean willRun() {
        if(getRNG().nextDouble() <= 0.23) {
            return false;
        }
        return true;
    }
}

class Hippo extends Animal  {


	double runniBoi;

    public Hippo(Random random) {
        super(random);
    }
    
    public void run() {
        double x = 3.3 + (3.7 - 3.3) * getRNG().nextDouble();
        runniBoi += x;
    }

    public double getDistanceTravelled() {
        return runniBoi;
    }

    public boolean willRun() {
        if(getRNG().nextDouble() <= 0.02) {
            return false;
        }
        return true;
    }
}

class Cat extends Animal  {


	double runniBoi;

    public Cat(Random random) {
        super(random);
    }
    
    public void run() {
        double x = 3.3 + (3.9 - 3.3) * getRNG().nextDouble();
        runniBoi += x;
    }

    public double getDistanceTravelled() {
        return runniBoi;
    }

    public boolean willRun() {
        if(getRNG().nextDouble() <=0.03) {
            return false;
        }
        return true;
    }
}

class Dog extends Animal  {


    double runniBoi;

    public Dog(Random random) {
        super(random);
    }
    
    public void run() {
        double x = 3.5 + (4.1 - 3.5) * getRNG().nextDouble();
        runniBoi += x;
    }

    public double getDistanceTravelled() {
        return runniBoi;
    }

    public boolean willRun() {
        if(getRNG().nextDouble() <=0.09) {
            return false;
        }
        return true;
    }
}

class Rabbit extends Animal  {


    double runniBoi;

    public Rabbit(Random random) {
        super(random);
    }
    
    public void run() {
        double x = 0.2 + (6.6 - 0.2) * getRNG().nextDouble();
        runniBoi += x;
    }

    public double getDistanceTravelled() {
        return runniBoi;
    }

    public boolean willRun() {
        if(getRNG().nextDouble() <=0.02) {
            return false;
        }
        return true;
    }
}
