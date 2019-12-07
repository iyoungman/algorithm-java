package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-07.
 * https://www.acmicpc.net/problem/2156
 * n번째가 0번 연속, 1번 연속, 2번 연속으로 나눈다
 */

public class BOJ_2156_포도주시식 {

	private static int[] wines;
	private static int[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		wines = new int[n + 1];
		d = new int[n + 1];

		//포도주 입력
		for (int i = 1; i <= n; i++) {
			wines[i] = scanner.nextInt();
		}

		init(n);

		//결과 출력
		System.out.println(bottomUp(n));
	}

	private static void init(int n) {
		if (n == 1) {
			d[1] = wines[1];
		} else {
			d[1] = wines[1];
			d[2] = wines[1] + wines[2];
		}
	}

	private static int bottomUp(int n) {
		if (n <= 2) {
			return d[n];
		}

		for (int i = 3; i <= n; i++) {
			int tempOne = d[i - 1];
			int tempTwo = d[i - 2] + wines[i];
			int tempThree = d[i - 3] + wines[i - 1] + wines[i];
			d[i] = Math.max(tempOne, Math.max(tempTwo, tempThree));
		}

		return d[n];
	}
}
