package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-20.
 * https://www.acmicpc.net/problem/10844
 */

public class BOJ_10844_쉬운계단수 {

	private static long[][] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		d = new long[n + 1][10];
		System.out.println(bottomUp(n));
	}

	private static long bottomUp(int n) {
		if (n == 1) {
			return 9;
		}

		for (int i = 1; i <= 9; i++) {
			d[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j >= 1 && j <= 8) {//1~8
					d[i][j] = d[i - 1][j - 1] + d[i - 1][j + 1];
				} else if (j == 0) {//0
					d[i][j] = d[i - 1][j + 1];
				} else {//9
					d[i][j] = d[i - 1][j - 1];
				}
				d[i][j] = d[i][j] % 1000000000;//나누기 조건이 있는 문제는 매 연산시 나누기를 해주자(범위 문제)
			}
		}

		long result = 0;
		for (int i = 0; i <= 9; i++) {
			result = result + d[n][i];
		}

		return result % 1000000000;
	}
}
