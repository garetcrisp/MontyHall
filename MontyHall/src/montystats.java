import java.util.Arrays;
import java.util.Scanner;
public class montystats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Monty's Game Show Extravaganza!!!!");
		System.out.println("For this game there will be a prize behind one of three doors.");
		System.out.println("Once one is picked, a remaining door will be eliminated");
		System.out.println("You will have the option to keep your door or switch to a new one.");
		System.out.println("We will keep track of how often you win depending on what you choose.");
		
		//We obviously need to make this random but i went ahead and set up a 2d array
		
		int[ ][ ] threedoors = new int[2][3];
		
		threedoors[0][0] = 1;
		threedoors[0][1] = 2;
		threedoors[0][2] = 3;
		threedoors[1][0] = 1000;
		threedoors[0][0] = 0;
		threedoors[0][0] = 0;
	
		//We could probably format this to make it look better in the console
		System.out.println(Arrays.deepToString(threedoors));
	}

}
