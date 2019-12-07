package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-12.
 * https://www.acmicpc.net/problem/12865
 */

public class BOJ_12865_평범한배낭 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//물품의 수
		int k = scanner.nextInt();//무게
		int[] weights = new int[n + 1];
		int[] values = new int[n + 1];
		int[][] d = new int[101][1000001];

		//입력
		for (int i = 1; i <= n; i++) {
			weights[i] = scanner.nextInt();//무게 입력
			values[i] = scanner.nextInt();//가치 입력
		}

		//BottomUp
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				d[i][j] = d[i - 1][j];//i 번째를 가져가지 않은 상태
				if (j - weights[i] >= 0) {
					//i 번째를 가져가지 않은 것, 가져간 것 비교
					d[i][j] = Math.max(d[i][j], d[i - 1][j - weights[i]] + values[i]);
				}
			}
		}

		//출력
		System.out.println(d[n][k]);
	}
}
