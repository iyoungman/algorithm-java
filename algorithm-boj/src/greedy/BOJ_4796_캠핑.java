package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-15.
 * https://www.acmicpc.net/problem/4796
 */

public class BOJ_4796_캠핑 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnt = 0;

		while (true) {
			//입력
			int l = scanner.nextInt();//사용 날짜
			int p = scanner.nextInt();//연속 날짜
			int v = scanner.nextInt();//휴가 날짜

			//검사
			if (checkEnd(l, p, v)) {
				break;
			}
			cnt++;

			int quotient = v / p;
			int remainder = Math.min(v % p, l);
			int result = (quotient * l) + remainder;

			//출력
			System.out.println("Case " + cnt + ": " + result);
		}
	}

	private static boolean checkEnd(int l, int p, int v) {
		return l == 0 && p == 0 && v == 0;
	}
}
