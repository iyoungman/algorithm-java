package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-03.
 * https://www.acmicpc.net/problem/9465
 */

public class BOJ_9465_스티커 {

	private static int[][] d;
	private static int[][] scores;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();//테스트 케이스 개수

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			scores = new int[2][n + 1];
			d = new int[2][n + 1];

			//점수 입력
			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= n; k++) {//1~n 입력
					scores[j][k] = scanner.nextInt();
				}
			}

			init(n);

			//결과 출력
			System.out.println(bottomUp(n));
		}
	}

	private static void init(int n) {
		d[0][1] = scores[0][1];
		d[1][1] = scores[1][1];

		if(n >= 2) {
			d[0][2] = scores[1][1] + scores[0][2];
			d[1][2] = scores[0][1] + scores[1][2];
		}
	}

	private static int bottomUp(int n) {
		if (n <= 2) {
			return Math.max(d[0][n], d[1][n]);
		}

		for (int i = 3; i <= n; i++) {
			int sumOne = Math.max(d[0][i-2], d[1][i-2]) + scores[0][i];
			int sumTwo = d[1][i-1] + scores[0][i];
			d[0][i] = Math.max(sumOne, sumTwo);

			sumOne = Math.max(d[0][i-2], d[1][i-2]) + scores[1][i];
			sumTwo = d[0][i-1] + scores[1][i];
			d[1][i] = Math.max(sumOne, sumTwo);
		}

		return Math.max(d[0][n], d[1][n]);
	}
}
