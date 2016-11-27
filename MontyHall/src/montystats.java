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
		
		// Switch statement to choose between methods
		switch (userChoice) {
			// Could use for loops or while loops to keep these going
			case 1: keepSameDoor();
			case 2: changeDoors();
		}
		
		//We could probably format this to make it look better in the console
		System.out.println(Arrays.deepToString(threedoors));
	}

	// Method for keeping the same door.
	private static void keepSameDoor() {
		Random rand = new Random();
		double timesCorrect = 0;
		int n = 10000; 
		for (int i = 0; i <= n; i++) {
			// randomly chooses a door
			int doorChoice = rand.nextInt(3);
			// places the "prize" behind a random door
			int doorFiller = rand.nextInt(3);
			// keep track of how many times the correct door is chosen
			if (doorChoice == doorFiller) {
				timesCorrect++;
			}
		}
		System.out.println(timesCorrect / n);
	}

	// Method for switching eliminating one door and then choosing another door. 
	private static void changeDoors() {
		Random rand = new Random();
		double timesCorrect = 0;
		int n = 100000;
		for (int i = 0; i <= n; i++) {
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
		System.out.print(timesCorrect / n);
	}
	

	

}
