package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-18.
 * https://www.acmicpc.net/problem/11727
 * n번째 올 수 있는 것은 2 x 1 짜리 가로, 2 x 1 짜리 세로, 2 x 2 짜리가 올 수 있으므로 점화식을 구할 수 있다
 */

public class BOJ_11727_2xN타일링2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] d = new int[n + 1];

		d[0] = 1;
		d[1] = 1;

		//BottomUp
		for (int i = 2; i < n + 1; i++) {
			d[i] = d[i - 1] + (d[i - 2] * 2);
			d[i] = d[i] % 10007;
		}

		//출력
		System.out.println(d[n]);
	}
}
