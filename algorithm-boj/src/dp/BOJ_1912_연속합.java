package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-02.
 * https://www.acmicpc.net/problem/1912
 */

public class BOJ_1912_연속합 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		int[] d = new int[n];

		//입력
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		d[0] = nums[0];

		for (int i = 1; i < n; i++) {
			if(d[i-1] < 0) {
				d[i] = nums[i];
				continue;
			}
			d[i] = d[i-1] + nums[i];
		}

		int maxSum = Arrays.stream(d)
				.max()
				.getAsInt();

		System.out.println(maxSum);
	}
}
