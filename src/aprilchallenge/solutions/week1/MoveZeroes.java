package aprilchallenge.solutions.week1;

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
