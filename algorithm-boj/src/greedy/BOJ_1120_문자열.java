package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-23.
 * https://www.acmicpc.net/problem/1120
 */

public class BOJ_1120_문자열 {

	private static int min = 50;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		int difference = b.length() - a.length();

		for (int i = 0; i <= difference; i++) {
			String subB = b.substring(i, i + a.length());
			getDifferenceCount(a, subB);
		}

		//결과 출력
		System.out.println(min);
	}

	private static void getDifferenceCount(String aStr, String bStr) {
		int count = 0;
		for (int i = 0; i < aStr.length(); i++) {//A와 B 비교
			if (aStr.charAt(i) != bStr.charAt(i)) {
				count++;
			}
		}
		if (count < min) {
			min = count;
		}
	}
}
