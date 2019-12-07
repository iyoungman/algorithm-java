package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-16.
 * https://www.acmicpc.net/problem/1065
 */

public class BOJ_1065_한수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int result = (n < 100) ? n : getCount(n);
		System.out.println(result);
	}

	private static int getCount(int n) {
		int count = 99;

		for (int i = 100; i <= n; i++) {
			if (isDifferential(i)) {
				count++;
			}
		}

		return count;
	}

	private static boolean isDifferential(int n) {
		int num1 = n / 100;//100의 자리
		int num2 = n / 10 % 10;//10의 자리
		int num3 = n % 10;//1의 자리

		return (num1 - num2) == (num2 - num3);
	}

}
