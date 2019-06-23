package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-18.
 * https://www.acmicpc.net/problem/1463
 * d[n] -> n을 1로 만드는데 필요한 연산의 최소값
 * 경우를 나눈다.. d[n/3], d[n/2], d[n-1]
 * d[n/3]을 예로 들면, d[n] = d[n/3] + 1;
 * 매 순간의 최소값들을 비교한다
 */

public class BOJ_1463_1로만들기 {

	private static int[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		d = new int[N + 1];

		System.out.println(bottomUp(N));
	}

	private static int topDown(int n) {
		if (n == 1) {
			return 0;
		}
		if (d[n] > 0) {//이미 저장해놓은 값이 있다면
			return d[n];
		}

		d[n] = topDown(n - 1) + 1;
		if (n % 2 == 0) {
			int temp = topDown(n / 2) + 1;
			if (d[n] > temp) {//이 연산이 더 작다면
				d[n] = temp;
			}
		}
		if (n % 3 == 0) {
			int temp = topDown(n / 3) + 1;
			if (d[n] > temp) {//이 연산이 더 작다면
				d[n] = temp;
			}
		}
		return d[n];
	}

	private static int bottomUp(int n) {
		d[1] = 0;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
				d[i] = d[i / 2] + 1;
			}
			if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
				d[i] = d[i / 3] + 1;
			}
		}
		return d[n];
	}
}
