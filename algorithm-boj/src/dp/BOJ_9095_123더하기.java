package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-20.
 * https://www.acmicpc.net/problem/9095
 */

public class BOJ_9095_123더하기 {

	private static int[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();
			d = new int[n + 1];
			System.out.println(topDown(n));
		}
	}

	private static int topDown(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		d[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
		return d[n];
	}

	private static int bottomUp(int n) {
		if (n == 1 || n == 2) {
			return n;
		}

		d[0] = 1;
		d[1] = 1;
		d[2] = 2;

		for (int i = 3; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2] + d[i - 3];
		}

		return d[n];
	}
}
