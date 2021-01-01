package general.solutions;

public class LargerBinaryTreeBranch {
	
	private static final String LEFT = "Left";
	private static final String RIGHT = "Right";
	
	public static int leftNodeFactorial(int i) {
		int sum = 0;
		do {
			sum += (int) Math.pow(2, i--);
		} while (i >= 0);
		return sum;
	}

	public static String solution(long[] arr) {
		String answer = "";
		if (arr.length > 2) {
			if (arr.length == 3) {
				answer = arr[1] == arr[2] ? answer : arr[1] > arr[2] ? LEFT : RIGHT;
			} else {
				int leftDepth = 0, rightDepth = 1, depthCounter = 1;
				long leftSum = arr[1];
				long rightSum = arr[2];
				do {
					int startVal = depthCounter;
					leftDepth = leftNodeFactorial(depthCounter);
					rightDepth = ((int) (Math.pow(2, depthCounter++))) + ((int) (Math.pow(2, depthCounter))) - 1;
					int offset = rightDepth - leftDepth - 1;
					int toOffset = 0;
					do {
						if (leftDepth < arr.length)
							leftSum += arr[leftDepth] != -1 ? arr[leftDepth] : 0;
						if ((rightDepth + toOffset) < arr.length) {
							rightSum += arr[rightDepth + toOffset] != -1 ? arr[rightDepth + toOffset++] : 0;
						}
					} while (++leftDepth < rightDepth);
				} while (leftDepth < arr.length);
				
				if (leftSum > rightSum)
					answer = LEFT;
				if (rightSum > leftSum)
					answer = RIGHT;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		long[][] arr = {
				{1, 10, 5, 1, 0, 6 },
				{}, 
				{1}, 
				{1, 2, 2},
				{1, 2, 3, 4, 5, 6, 7},
				{7, 6, 5, 4, 3, 2, 1, -1, -1, -1, -1, 12},
				{7, 6, 5, 4, 3, 2, 1, -1, -1, 12}
		};
		for (int x = 0; x < arr.length; x++) {
			System.out.println(x + " : " + solution(arr[x]));
		}
	}

}
