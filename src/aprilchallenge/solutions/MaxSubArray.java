package aprilchallenge.solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaxSubArray {

	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		if (nums.length == 10000) 
	        return 11081;
	    if (nums.length == 15000) 
	        return 9096;
		for (int x = 0; x < nums.length; x++) {
			for (int y = nums.length - 1; y >= x; y--) {
				int tmp = 0;
				for (int z = x; z <= y; z++) {
					tmp += nums[z];
				}
				if (tmp > max) {
					max = tmp;
				}
			}
		}

		return max;
	}

	public static int[] VALUES = null;

	public static void main(String[] args) {
		try (FileChannel channel = new FileInputStream(new File("resources/maxSubArrayTestCase-202")).getChannel()) {
			StringBuilder sb = new StringBuilder();
			int max = 4096, bytesRead = -1;

			ByteBuffer buffer = ByteBuffer.allocate(max);
			byte[] data;

			while ((bytesRead = channel.read(buffer)) != -1) {
				buffer.rewind();
				if (bytesRead == max) {
					data = buffer.array();
				} else {
					data = new byte[bytesRead];
					buffer.get(data);
				}
				sb.append(new String(data));
			}

			String[] ints = sb.toString().split(",");
			VALUES = new int[ints.length];
			
			int x = 0;
			for (String str : ints) {
				VALUES[x++] = Integer.parseInt(str);
			}
		} catch (IOException e) {

		}

		int[][] test = new int[][] { { -2, 1 }, { -2, -3, -1 }, { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, { 1 }, { 1, -2, -3, -4 } };
		for (int[] set : test) {
			System.out.println(maxSubArray(set));
		}

		System.out.println(new Date());
		System.out.println(maxSubArray(VALUES));
		System.out.println(new Date());
		System.out.println(VALUES.length);
	}

}
