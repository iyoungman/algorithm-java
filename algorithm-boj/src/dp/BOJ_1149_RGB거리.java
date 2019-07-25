package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-25.
 * https://www.acmicpc.net/problem/1149
 */

public class BOJ_1149_RGB거리 {

	private static int[][] color = new int[1000 + 1][3];
	private static int[][] d = new int[1000 + 1][3];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//집의 수

		//입력
		for (int i = 1; i <= n; i++) {
			color[i][0] = scanner.nextInt();//빨강
			color[i][1] = scanner.nextInt();//초록
			color[i][2] = scanner.nextInt();//파랑
		}

		//출력
		System.out.println(bottomUp(n));
	}

	private static int bottomUp(int n) {
		if (n == 1) {
			return min(color[n]);
		}

		d[1][0] = color[1][0];
		d[1][1] = color[1][1];
		d[1][2] = color[1][2];

		for (int i = 2; i <= n; i++) {
			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + color[i][0];
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + color[i][1];
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + color[i][2];
		}
		return min(d[n]);
	}

	private static int min(int[] colors) {
		return Arrays.stream(colors)
				.min()
				.getAsInt();
	}
}
