package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-02.
 * https://www.acmicpc.net/problem/2309
 * 경우의 수가 적으므로 모든 경우를 탐색하는 완전탐색을 이용 가능하다
 */

public class BOJ_2309_일곱난쟁이 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] heights = new int[9];
		int non1 = 0, non2 = 0;

		//입력
		for (int i = 0; i < 9; i++) {
			heights[i] = scanner.nextInt();
		}

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if(isSumHundred(heights, i, j)) {//100이면
					non1 = heights[i];
					non2 = heights[j];
					break;
				}
			}
		}

		//출력
		Arrays.sort(heights);
		for (int i = 0; i < 9; i++) {
			if(heights[i] == non1 || heights[i] == non2) {
				continue;
			}
			System.out.println(heights[i]);
		}

	}

	private static boolean isSumHundred(int[] heights, int non1, int non2) {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			if(i == non1 || i == non2) {
				continue;
			}
			sum = sum + heights[i];
		}

		return sum == 100;
	}
}
