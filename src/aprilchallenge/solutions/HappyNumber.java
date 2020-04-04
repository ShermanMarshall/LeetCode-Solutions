package aprilchallenge.solutions;

/**
 * Day 2 challenge:
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example:
 * 
 * 		Input: 19
 * 			Output: true
 * 
 * 	Explanation: 
 * 		12 + 92 = 82
 * 		82 + 22 = 68
 * 		62 + 82 = 100
 * 		12 + 02 + 02 = 1
 * 
 * @author shermanmarshall
 *
 */
public class HappyNumber {

	public static int parseSumSquares(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += (int) Math.pow(((int) c) - ((int) '0'), 2);
        }
        return sum;
    }
	
	public boolean isHappy(int n) {
        String tmp = Integer.toString(n);
        int cycleCount = 10;
        do {
            n = parseSumSquares(tmp);
            tmp = Integer.toString(n);
        } while (n != 1 && --cycleCount > 0);
        return n == 1;
    }

	public static void main(String[] args) {

	}

}
