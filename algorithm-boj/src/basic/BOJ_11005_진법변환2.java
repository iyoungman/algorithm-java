package basic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-04.
 * https://www.acmicpc.net/problem/11005
 * 10진법 -> B진법
 */

public class BOJ_11005_진법변환2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//수
		int b = scanner.nextInt();//진법
		ArrayList<Character> results = new ArrayList<>();

		while (true) {
			int remain = n % b;
			results.add(getChar(remain));
			n = n / b;

			if (n == 0) {
				break;
			}
		}

		//결과 출력
		for (int i = results.size() - 1; i >= 0; i--) {
			System.out.print(results.get(i));
		}
	}

	private static char getChar(int num) {
		if (num >= 10) {
			return (char) (num + 55);
		} else {
			return (char) (num + 48);
		}
	}
}
