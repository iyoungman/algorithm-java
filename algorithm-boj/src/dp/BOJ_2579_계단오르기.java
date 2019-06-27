package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-26.
 * https://www.acmicpc.net/problem/2579
 * 어차피 구하는 것은 d[n]이기 때문에 쉽게 생각할것
 */

public class BOJ_2579_계단오르기 {

	private static long[] d;
	private static long[] score;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		d = new long[n + 1];
		score = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			score[i] = scanner.nextLong();
		}

		System.out.println(bottomUp(n));
	}

	private static long bottomUp(int n) {
		d[1] = score[1];
		d[2] = d[1] + score[2];

		if (n <= 2) {
			return d[n];
		}

		for (int i = 3; i <= n; i++) {
			long temp1 = d[i - 3] + score[i - 1] + score[i];
			long temp2 = d[i - 2] + score[i];
			d[i] = temp1 >= temp2 ? temp1 : temp2;
		}

		return d[n];
	}
}

