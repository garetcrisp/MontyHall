import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class montystats {

	public static void main(String[] args) {

		System.out.println("Welcome to Monty's Game Show Extravaganza!!!!");
		System.out.println("For this game there will be a prize behind one of three doors.");
		System.out.println("Once one is picked, a remaining door will be eliminated");
		System.out.println("You will have the option to keep your door or switch to a new one.");
		System.out.println("We will keep track of how often you win depending on what you choose.");
		
		//We obviously need to make this random but i went ahead and set up a 2d array
		
		int[ ][ ] threedoors = new int[2][3];
		
		/*threedoors[0][0] = 1;
		threedoors[0][1] = 2;
		threedoors[0][2] = 3;
		threedoors[1][0] = 1000;
		threedoors[0][0] = 0;
		threedoors[0][0] = 0;
		*/
		boolean endgame=true;
		
		while (endgame){
		// Ask for user to pick whether the door will be kept or switched 
			int userChoice = 0;
			Scanner input = new Scanner(System.in);
			do{
				System.out.println("Enter 1 if you would like for the program to be ran in such a way " +
					"that a new door is not chosen. \nSelect 2 if you want the door to be switched " +
					"each time. ");
				while (!(input.hasNextInt(2) || input.hasNextInt(3))) {
				System.out.println("Please make a valid selection...");
				input.next();
				}
				userChoice = input.nextInt();
			} while (!(userChoice == 1 || userChoice == 2));
			
			// Ask how many times for game to be simulated
			int numberOfSimulations = 0;
			Scanner input2 = new Scanner(System.in);
			do{
				System.out.println("How many times would you like the game to be simulated? ");
				while (!(input2.hasNextInt())) {
					System.out.println("Please make a valid selection...");
					input2.next();
				}
				numberOfSimulations = input2.nextInt();
				System.out.println(numberOfSimulations);
			} while (numberOfSimulations == 0);
			
	
		
				// Switch statement to choose between methods
				switch (userChoice) {
				// Could use for loops or while loops to keep these going
					case 1: keepSameDoor(numberOfSimulations); break;
					case 2: changeDoors(numberOfSimulations); break; 
			}
				String wishToContinue;
				Scanner choice = new Scanner(System.in);			
				System.out.println("Do you want to run the program again?");
				wishToContinue= choice.next();
				
				while (!(wishToContinue.equalsIgnoreCase("yes") 
				    	|| wishToContinue.equalsIgnoreCase("no"))) {
				        System.out.println("Error, please enter a valid selection...");
				        wishToContinue = choice.next(); // this line advances the scanner
			   }
			   if (wishToContinue.equalsIgnoreCase("no")) {
				  endgame = false;	
			   } 
		}
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		System.out.print(str);
	}

		
	// Method for keeping the same door.
	private static double keepSameDoor(int number) {
		Random rand = new Random();
		double timesCorrect = 0;
		for (int i = 0; i <= number; i++) {
			// randomly chooses a door
			int doorChoice = rand.nextInt(3);
			// places the "prize" behind a random door
			int doorFiller = rand.nextInt(3);
			// keep track of how many times the correct door is chosen
			if (doorChoice == doorFiller) {
				timesCorrect++;
			}
		}
		double percent = (timesCorrect / number) * 100;
		System.out.print("You got prize " + percent + 
				"% of the time.");
		return percent;
	}

	// Method for switching eliminating one door and then choosing another door. 
	private static double changeDoors(int number) {
		Random rand = new Random();
		double timesCorrect = 0;
		for (int i = 0; i <= number; i++) {
			int doorChoice = rand.nextInt(3), doorFiller = rand.nextInt(3), 
					doorEliminator, doorChanger;
			// insure that an empty door is eliminated 
			do {
				doorEliminator = rand.nextInt(3);
			} while (doorEliminator == doorChoice || doorEliminator == doorFiller);
			// switch to the other door
			do {
				doorChanger = rand.nextInt(3);
			} while (doorChanger == doorEliminator || doorChanger == doorChoice);
			if (doorChanger == doorFiller) {
				timesCorrect++;
			}
		}
		double percent = (timesCorrect / number) * 100;
		System.out.print("You got prize " + percent + 
				"% of the time.");
		return percent;
	}
	
	
}
