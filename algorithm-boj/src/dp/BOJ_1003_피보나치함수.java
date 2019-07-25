package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-25.
 * https://www.acmicpc.net/problem/1003
 */

public class BOJ_1003_피보나치함수 {

	private static int[] dpZero = new int[41];
	private static int[] dpOne = new int[41];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();//테스트 케이스
		init();

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int[] results = bottomUp(n);

			//결과 출력
			System.out.println(results[0] + " " + results[1]);
		}
	}

	private static void init() {
		dpZero[0] = 1;
		dpOne[1] = 1;
	}

	private static int[] bottomUp(int n) {
		if (n == 0 || n == 1) {
			return new int[]{dpZero[n], dpOne[n]};
		}

		for (int i = 2; i <= n; i++) {
			dpZero[i] = dpZero[i - 1] + dpZero[i - 2];
			dpOne[i] = dpOne[i - 1] + dpOne[i - 2];
		}
		return new int[]{dpZero[n], dpOne[n]};
	}
}
