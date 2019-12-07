package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-04-18.
 * https://www.acmicpc.net/problem/10824
 */

public class BOJ_10824_네수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		long c = scanner.nextLong();
		long d = scanner.nextLong();

		long hap = Long.parseLong(String.valueOf(a).concat(String.valueOf(b)))
				+ Long.parseLong(String.valueOf(c).concat(String.valueOf(d)));

		//결과 출력
		System.out.println(hap);
	}
}
