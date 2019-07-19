package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-30.
 * https://www.acmicpc.net/problem/11053
 * d[n] n-1까지 수들 중 nums[n]보다 작은 값에서 가장 큰 dp+1
 */

public class BOJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n + 1];
		int[] d = new int[n + 1];

		//입력
		for (int i = 1; i < n + 1; i++) {
			nums[i] = scanner.nextInt();
		}

		d[1] = 1;

		//BottomUp
		for (int i = 2; i < n + 1; i++) {
			for (int k = 1; k < i; k++) {
				d[i] = (nums[i] > nums[k]) ? Math.max(d[i], d[k] + 1) : Math.max(d[i], 1);
			}
		}

		//출력
		Arrays.sort(d);
		System.out.println(d[n]);
	}
}
