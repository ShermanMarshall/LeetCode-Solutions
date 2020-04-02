package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Day 1 challenge:
 * 
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * 		Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * 		Example 1:
 * 			Input: [2,2,1]
 * 			Output: 1
 * 
 * 		Example 2:
 * 			Input: [4,1,2,1,2]
 * 			Output: 4
 * 
 * @author shermanmarshall
 *
 */
public class SingleNumber {

	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> numbersAndCounts = new HashMap(nums.length >> 1);
		for (int num : nums) {
			Integer count = numbersAndCounts.get(num);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			numbersAndCounts.put(num, count);
		}
		int single = 0;
		for (Map.Entry<Integer, Integer> entry : numbersAndCounts.entrySet()) {
			if (entry.getValue() != 2) {
				single = entry.getKey();
				break;
			}
		}
		return single;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
