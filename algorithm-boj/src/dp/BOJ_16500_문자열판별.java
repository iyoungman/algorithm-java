package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-07.
 * https://www.acmicpc.net/problem/16500
 */

public class BOJ_16500_문자열판별 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();//문자열
		int n = scanner.nextInt();//개수
		scanner.nextLine();
		String[] list = new String[n];

		//목록 입력
		for (int i = 0; i < n; i++) {
			list[i] = scanner.nextLine();
		}

		for (int i = 0; i < n; i++) {
			String index = list[i];
			if (str.contains(index)) {
				str = str.replaceAll(index, "");
			}
		}

		//결과 출력
		int result = str.length() == 0 ? 1 : 0;
		System.out.println(result);
	}
}
