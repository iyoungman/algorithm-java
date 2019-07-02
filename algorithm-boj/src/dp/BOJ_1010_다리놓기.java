package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-01.
 * https://www.acmicpc.net/problem/1010
 * 단순 조합말고 점화식으로 생각해내기 좀 힘듬
 */

public class BOJ_1010_다리놓기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		int d[][];

		for (int t = 0; t < testCase; t++) {
			int west = scanner.nextInt();
			int east = scanner.nextInt();
			d = new int[west + 1][east + 1];

			//초기화
			for (int i = 1; i < east + 1; i++) {
				d[1][i] = i;
			}

			//BottomUp
			for (int i = 2; i < west + 1; i++) {
				for (int j = i; j < east + 1; j++) {
					for (int k = j; k >= i; k--)
						d[i][j] = d[i][j] + d[i - 1][k - 1];
				}
			}

			System.out.println(d[west][east]);
		}
	}
}
