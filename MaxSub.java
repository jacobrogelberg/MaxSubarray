import java.util.Scanner;

/**
 * A class for the Maximum-Subarray Problem, solved in linear time.
 * 
 * @author jacob
 * 
 */
public class MaxSub
{
	public static Scanner s = new Scanner(System.in);
	public static int[] allNumbers;
	public static int sum = 0;
	public static int maxSumEnd = 0; 
	public static int leftIndex = 0;
    public static int rightIndex = 0;

	 /**
	 * Main method the runs the program
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		MaxSub msb = new MaxSub();
		msb.setup();
		msb.evaluate();
		msb.print();	
	}

	/**
	 * Setup method that parses the input string and puts it into an array to be compared
	 */
	public void setup() 
	{
		System.out.println("Please input all your numbers, separated by commas:");
		String[] allNumString = s.nextLine().split(",");
		allNumbers = new int[allNumString.length];
		for (int i = 0; i < allNumString.length; i++) {
			allNumbers[i] = Integer.parseInt(allNumString[i]);
		}
	}

	/**
	 * Evaluates the array and finds the maximum sub-array and returns two things:
	 * 		1. left and right index of the max subarray. 
	 * 		2. max subarray total
	 */
	public void evaluate() {
		int i = 0;
		for (i = 0; i < allNumbers.length; i++) {
			
			maxSumEnd = maxSumEnd + allNumbers[i];
			
			if (sum < maxSumEnd) {
				rightIndex = i;
				sum = maxSumEnd; 
				
			}
			
			if (maxSumEnd < 0) {
				leftIndex = 1 + i;
				maxSumEnd = 0; 
			}	
		}
	}
	
	/*
	 * Sample input that can be used to test the algorithm:
	 * 
	 * 				1,1,2,-2,3,3,4,-4
	 */

	/**
	 * Prints the left and right indexes and the sum of the max subarray
	 */
	public void print() {

		System.out.println("The total sum of the maximum subarray is " + sum);
		System.out.println("The left index is " + leftIndex + " and the right index is " + rightIndex);
	}
}