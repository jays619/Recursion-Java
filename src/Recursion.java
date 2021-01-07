import java.util.Arrays;

//import java.util.Random;

/**
	 *
	 * 
	 */
public class Recursion {

	// Track number of calls.
	private int iRecursiveCalls = 0;

	public void runRecursiveTest() {

		// Establish array size.
		int iArraySize = 10;

		// Create array 1,000 in length of int type.
		String[] aiString = new String[iArraySize];
		// Create a Random object.

		aiString[0] = "frank";
		aiString[1] = "Toby";
		aiString[2] = "jay";
		aiString[3] = "lars";
		aiString[4] = "vic vinger";
		aiString[5] = "Nightman";
		aiString[6] = "Dayman";
		aiString[7] = "Abe";
		aiString[8] = "Emmanuel";
		aiString[9] = "Victorica";

		// Pick a target number.
		String tTarget = aiString[0];

		// Sort array.
		Arrays.sort(aiString);

		System.out.println("Target num: " + tTarget);

		// BEGIN Binary Search.

		System.out.println("--- Begin Binary Search ---");
		long lBegTime = System.nanoTime();
		findNumbersBinarySearch(aiString, tTarget, 0, iArraySize - 1);
		long lEndTime = System.nanoTime();
		System.out.println("Elapsed time: " + (lEndTime - lBegTime));
		System.out.println("Recursive calls: " + iRecursiveCalls);
		System.out.println("--- End Binary Search ---");

		// BEGIN Traditional Search.

		System.out.println("--- Begin Traditional Search ---");
		lBegTime = System.nanoTime();
		findNumberTraditionalSearch(aiString, tTarget);
		lEndTime = System.nanoTime();
		System.out.println("Elapsed time: " + (lEndTime - lBegTime));
		System.out.println("--- End Traditional Search ---");

	}

	// Recursive function to find index of a known value contained in array.
	private int findNumbersBinarySearch(String[] aiString, String iTarget,
			int iLow, int iHigh) {

		iRecursiveCalls++;

		int iMiddle = (iHigh + iLow) / 2;

		// Check if target is the middle.
		if (iTarget.compareTo(aiString[iMiddle]) == 0) {
			return iMiddle;
		}
		// Check if target is greater than middle.
		else if (iTarget.compareTo(aiString[iMiddle]) > 0) {

			// Recursively call this function adjusting low to the middle.
			return findNumbersBinarySearch(aiString, iTarget, iMiddle + 1,
					iHigh);
		}
		// target is less than middle.
		else {

			// Recursively call this function adjusting high to the middle.
			return findNumbersBinarySearch(aiString, iTarget, iLow, iMiddle - 1);
		}
	}

	private int findNumberTraditionalSearch(String[] aiString, String iTarget) {

		for (int x = 0; x < aiString.length; x++) {
			if (aiString[x].equals(iTarget)) {
				return x;
			}
		}

		return -1;
	}
}
