package string;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by YoungMan on 2019-08-03.
 * https://www.acmicpc.net/problem/1152
 */

public class BOJ_1152_단어의개수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
		//결과 출력
		System.out.println(stringTokenizer.countTokens());
	}
}
