package string;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-04.
 * https://www.acmicpc.net/problem/1475
 */

public class BOJ_1475_방번호 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();//방번호
		int[] set = new int[10];

		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';//char to int
			set[num]++;
		}

		int max = 0;
		int temp = 0;
		for (int i = 0; i < set.length - 1; i++) {
			if (i == 6) {
				temp = set[6] + set[9];
				temp = (temp % 2 == 1) ? temp / 2 + 1 : temp / 2;
			} else {
				temp = set[i];
			}

			max = Math.max(max, temp);
		}

		//결과 출력
		System.out.println(max);
	}
}
