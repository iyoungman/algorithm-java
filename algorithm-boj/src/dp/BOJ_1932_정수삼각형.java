package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-27.
 * https://www.acmicpc.net/problem/1932
 */

public class BOJ_1932_정수삼각형 {

	private static int[][] triangle = new int[500 + 1][500 + 1];
	private static int[][] d = new int[500 + 1][500 + 1];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//삼각형의 크기

		//입력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				triangle[i][j] = scanner.nextInt();
			}
		}

		//출력
		System.out.println(bottomUp(n));
	}

	private static int bottomUp(int n) {
		if (n == 1) {
			return triangle[1][1];
		}
		d[1][1] = triangle[1][1];

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					int before = getBeforeIndex(j, i);
					d[i][j] = d[i - 1][before] + triangle[i][j];
				} else {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + triangle[i][j];
				}
			}
		}

		return Arrays.stream(d[n])
				.max()
				.getAsInt();
	}

	private static int getBeforeIndex(int j, int i) {
		return (j == 1) ? 1 : i - 1;
	}

}
