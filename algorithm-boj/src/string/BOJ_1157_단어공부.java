package string;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-03.
 * https://www.acmicpc.net/problem/1157
 * 아스키코드 이용
 */

public class BOJ_1157_단어공부 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine().toUpperCase();//알파벳 입력
		char[] alphabets = new char[input.length()];//알파벳 목록
		int[] counts = new int[26];//알파벳 개수 저장

		for (int i = 0; i < input.length(); i++) {
			alphabets[i] = input.charAt(i);
		}

		int max = 0;
		char result = '?';
		for (int i = 0; i < input.length(); i++) {
			int index = alphabets[i] - 65;
			counts[index]++;

			if (counts[index] > max) {
				max = counts[index];
				result = alphabets[i];
			} else if (counts[index] == max) {
				result = '?';
			}
		}

		//결과 출력
		System.out.println(result);
	}
}
