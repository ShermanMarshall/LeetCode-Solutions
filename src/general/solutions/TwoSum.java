package general.solutions;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * @author shermanmarshall
 *
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		int[] answer = new int[2];
		boolean hasNotCompleted = true;
		for (int x = 0; hasNotCompleted && x < nums.length; x++) {
			for (int y = 0; hasNotCompleted && y < nums.length; y++) {
				if (y == x) {
					if (y == nums.length) {
						continue;
					} else {
						y++;
					}
				}
				if ((nums[x] + nums[y]) == target) {
					answer[0] = x;
					answer[1] = y;
					hasNotCompleted = false;
					System.out.println(x + " " + y + " = " + (nums[x] + nums[y]));
				}
			}
		}
		return answer;
	}

	public static void main(String... args) {
		int[] vals = twoSum(new int[] { 3, 2, 4 }, 6);
		System.out.println(vals[0] == 1 && vals[1] == 2);
	}
}
