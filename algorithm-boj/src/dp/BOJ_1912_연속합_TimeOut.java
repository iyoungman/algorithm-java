package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-02.
 * https://www.acmicpc.net/problem/1912
 * https://jungmonster.tistory.com/126
 */

public class BOJ_1912_연속합_TimeOut {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		int maxSum = 0;

		//입력
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}


		for (int i = 0; i < n; i++) {
			int tempSum = 0;
			for (int j = i; j < n; j++) {
				tempSum = tempSum + nums[j];
				maxSum = Math.max(tempSum, maxSum);
			}
		}

		//출력
		System.out.println(maxSum);
	}
}
