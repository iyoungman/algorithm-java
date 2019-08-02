package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-01.
 * https://www.acmicpc.net/problem/1969
 */

public class BOJ_1969_DNA {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//DNA 수
		int m = scanner.nextInt();//문자열의 길이
		scanner.nextLine();
		char[][] texts = new char[n][m];
		char[] result = new char[m];

		//DNA 입력
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < m; j++) {
				texts[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < m; i++) {
			char[] compares = new char[n];
			for (int j = 0; j < n; j++) {
				compares[j] = texts[j][i];
			}
			Arrays.sort(compares);
			result[i] = getMaxChar(compares);
		}

		//출력
		System.out.println(result);
		System.out.println(getMinSum(texts, result));
	}

	private static Character getMaxChar(char[] compares) {
		char maxChar = compares[0];
		int max = 0;
		int temp = 1;

		for (int i = 1; i < compares.length; i++) {
			if (i == compares.length - 1) {//마지막 요소 체크
				if (compares[i] != compares[i - 1]) {
					temp = 1;
				} else {
					temp++;
				}
			}

			if (compares[i] != compares[i - 1] || i == compares.length - 1) {
				if (max < temp) {
					maxChar = compares[i - 1];
					max = temp;
				}
				temp = 1;
			} else {
				temp++;
			}
		}
		return maxChar;
	}

	private static int getMinSum(char[][] texts, char[] result) {
		int sum = 0;

		for (int i = 0; i < texts.length; i++) {
			for (int j = 0; j < texts[0].length; j++) {
				if(texts[i][j] != result[j]) {
					sum++;
				}
			}
		}
		return sum;
	}
}
