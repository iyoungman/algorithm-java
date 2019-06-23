package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-20.
 * https://www.acmicpc.net/problem/11726
 * 직접 규칙성을 찾아봤는데 피보나치다
 * 계속 숫자를 더하다보면 자료형의 크기를 넘을 수 있다
 * 크기를 넘은 다음에 나머지를 구하는건 당연히 에러기 때문에 매 연산마다 나머지를 구한다
 */

public class BOJ_11726_2xN타일링 {

	private static int[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		d = new int[n + 1];

		System.out.println(bottomUp(n));
	}

	private static int topDown(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		if (d[n] > 0) {
			return d[n];
		}
		d[n] = topDown(n - 1) + topDown(n - 2);
		d[n] %= 10007;//매 연산시 나머지
		return d[n];
	}

	private static int bottomUp(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		d[0] = 1;//없는것도 하나의 횟수다
		d[1] = 1;

		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] %= 10007;//매 연산시 나머지
		}
		return d[n];
	}
}
