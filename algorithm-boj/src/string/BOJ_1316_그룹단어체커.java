package string;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-14.
 * https://www.acmicpc.net/problem/1316
 */

public class BOJ_1316_그룹단어체커 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//단어의 개수
		scanner.nextLine();

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (isGroupWord(scanner.nextLine())) {
				result++;
			}
		}

		//결과 출력
		System.out.println(result);
	}

	private static boolean isGroupWord(String word) {
		int[] check = new int[26];

		for (int i = 1; i < word.length(); i++) {
			char before = word.charAt(i - 1);
			char current = word.charAt(i);

			if (check[current - 97] == -1) {//이미 지나간 단어이면
				return false;
			}

			if (word.charAt(i - 1) != word.charAt(i)) {//앞 단어와 다르면
				check[before - 97] = -1;
			}
		}

		return true;
	}

}
