package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-24.
 * https://www.acmicpc.net/problem/2012
 */

public class BOJ_2012_등수매기기 {

	private static int[] expectRank;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		expectRank = new int[n];
		long result = 0;

		for (int i = 0; i < n; i++) {
			expectRank[i] = scanner.nextInt();
		}

		//정렬
		Arrays.sort(expectRank);

		for (int i = 0; i < n; i++) {
			result = result + Math.abs((i + 1) - expectRank[i]);
		}

		//결과 출력
		System.out.println(result);
	}
}
