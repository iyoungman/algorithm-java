package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-18.
 * https://www.acmicpc.net/problem/2749
 * https://www.acmicpc.net/blog/view/28
 */

public class BOJ_2749_피보나치수3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();

		int div = 1000000;
		int pisano = div / 10 * 15;
		int[] d = new int[pisano];
		d[0] = 0;
		d[1] = 1;

		if(n < 2) {
			System.out.println(n);
		} else {
			for (int i = 2; i <= n; i++) {
				d[i] = d[i - 1] + d[i - 2];
				d[i] = d[i] % div;
			}

			//결과 출력
			int result = (int) (n % pisano);
			System.out.println(d[result]);
		}
	}
}
