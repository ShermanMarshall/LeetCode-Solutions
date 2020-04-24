package aprilchallenge.solutions.week1;

/**
 * @day 4
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 	You must do this in-place without making a copy of the array.
 * 	Minimize the total number of operations.
 * 
 * @author shermanmarshall
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroCount = 0, idx = 0;
        
        for (int i : nums) {
            if (i == 0) {
                zeroCount++;
            } else {
                nums[idx - zeroCount] = i;
            }
            idx++;
        }
        
        for (int x = nums.length - zeroCount; x < nums.length; x++) {
            nums[x] = 0;
        }
    }
    
    public static void output(int[] vals) {
    	System.out.print("[");
    	int x = 0;
    	for (int i : vals) {
    		System.out.print(i + (++x < vals.length ? ", " : ""));
    	}
    	System.out.println("]");
    }
    
	public static void main(String[] args) {
		int[] test1 = new int[] { 0,1,0,3,12 };
		moveZeroes(test1);
		output(test1);
		
		int[] test2 = new int[] { 1, 0, 3, 0, 12 };
		moveZeroes(test2);
		output(test2);
		
		int[] test3 = new int[] { 12, 4, 2, 0, 0, 0, 0, 0, 6, 1, 0, 3, 1 };
		moveZeroes(test3);
		output(test3);
		
		
	}

}
