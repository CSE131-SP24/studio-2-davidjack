package studio2;
import java.util.Scanner;
import java.util.Random;

public class RUin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount of money you start with: ");
		int startAmount = sc.nextInt();
		System.out.println("Enter the win probablity: ");
		double winChance = sc.nextDouble();
		System.out.println("Enter the amount of money you leave the casino: ");
		double winLimit = sc.nextDouble();
		System.out.println("Enter how many times you want to do simulation: ");
		int totalSimulations = sc.nextInt();
		
		double Chance = winChance * 1000;
		Random r = new Random();
		
		int c;
		int index = startAmount;
		int winDay = 0;
		double lossDay = 0.00;
		int round;
		for (int i = 0; i < totalSimulations; i++) {
			round = 0;
			startAmount = index;
			while (true) {
				int probablity = r.nextInt(1000)+1;
				if (probablity <= Chance) {
					startAmount++;
					round++;
					//System.out.println("The amount is " + startAmount);
				} else {
					startAmount--;
					round++;
					//System.out.println("The amount is " + startAmount);
				}
				if (startAmount == winLimit) {
					//System.out.println("You win!");
					winDay++;
					c = 0;
					break;
				}
				if (startAmount == 0) {
					//System.out.println("You loss");
					lossDay++;
					c = 1;
					break;
				}
			}
			if (c == 0) {
				System.out.println("Simulation " + (i+1) + ": " + round + " WIN" );
			} 
			if (c == 1) {
				System.out.println("Simulation " + (i+1) + ": " + round + " LOSS" );
			}
			
        }
		
		double ruin = (double)(lossDay/totalSimulations);
		double a = (1-winChance)/winChance;
		double expect;
		if (winChance == 0.5) {
			expect = index/winLimit;
		} else {
			expect = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1- Math.pow(a, winLimit));
		}
		
		System.out.println("Number of simulation: " + totalSimulations);
		System.out.println("Number of win: " + winDay);
		System.out.println("Number of loss: " + (int)lossDay);
		System.out.println("Ruin rate: " + ruin);
		System.out.println("Expected Ruin Rate: " + expect);
		
	}

}
