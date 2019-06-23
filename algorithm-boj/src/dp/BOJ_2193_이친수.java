package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-23.
 * https://www.acmicpc.net/problem/2193
 * D[i][j] => i자리 이친수의 개수 중에서 j로 끝나는 것의 개수
 * https://baked-corn.tistory.com/79
 */

public class BOJ_2193_이친수 {

	private static long[][] d = new long[91][2];//int 로 할경우 범위를 초과


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		//결과 출력
		System.out.println(bottomUp(n));
	}

	private static long bottomUp(int n) {
		d[1][0] = 0;//이친수는 0으로 시작하지 않는다
		d[1][1] = 1;

		if (n == 1) {
			return 1;
		}

		for (int i = 2; i <= n; i++) {
			d[i][0] = d[i-1][0] + d[i-1][1];
			d[i][1] = d[i-1][0];
		}

		return d[n][0] + d[n][1];//N자리 이친수 중 0으로 끝나는 것의 개수 + 1으로 끝나는 것의 개수
	}
}
