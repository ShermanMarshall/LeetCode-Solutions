package daily2020.december;

/**
 * 
 * @author shermanmarshall
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */

public class LargestHistogramArea {
	public int largestRectangleArea(int[] heights) {
        int max = heights.length == 0 ? 0 : Integer.MIN_VALUE;
        for (int i : heights) {
            int tmp = 0, maxTmp = Integer.MIN_VALUE;
            for (int x = 0; x < heights.length; x++) {
                if ((heights[x] - i) >= 0) {
                    tmp += i;
                } else {
                    maxTmp = maxTmp > tmp ? maxTmp : tmp;
                    tmp = 0;
                }
            }
            maxTmp = tmp > maxTmp ? tmp : maxTmp;
            max = max > maxTmp ? max : maxTmp;
        }
        return max;
    }
}
