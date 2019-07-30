package bruteforcesearch;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-30.
 * https://www.acmicpc.net/problem/1051
 */

public class BOJ_1051_숫자정사각형 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		int[][] square = new int[n][m];

		//입력
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < m; j++) {
				square[i][j] = line.charAt(j) - '0';
			}
		}

		int result = 1;
		for (int i = Math.min(n, m); i >= 2; i--) {
			if (isExistSquare(i, square)) {
				result = i * i;
				break;
			}
		}

		//결과 출력
		System.out.println(result);
	}

	private static boolean isExistSquare(int length, int[][] square) {
		int n = square.length;
		int m = square[0].length;
		int plus = length - 1;

		for (int i = 0; i + length <= n; i++) {
			for (int j = 0; j + length <= m; j++) {
				if(isEqual(square[i][j], square[i + plus][j], square[i][j + plus], square[i + plus][j + plus])) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isEqual(int a, int b, int c, int d) {
		return a == b && b == c && c == d;
	}
}
