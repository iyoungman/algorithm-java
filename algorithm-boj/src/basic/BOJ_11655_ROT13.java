package basic;

/**
 * Created by YoungMan on 2019-04-18.
 * https://www.acmicpc.net/problem/11655
 * StringBuilder 가 String 보다 성능이 좋다
 * char ch[]=str.toCharArray();
 * 대문자는 대문자끼리, 소문자는 소문자끼리 변환
 */

public class BOJ_11655_ROT13 {

	public static void main(String[] args) {
		String input1 = "Baekjoon Online Judge";
		String input2 = "One is 1";
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < input2.length(); i++) {

			char ch = input2.charAt(i);

			if (ch >= 'A' && ch <= 'M') {
				System.out.println(ch + 13);
				stringBuilder.append((char)(ch + 13));
				continue;
			}
			if (ch >= 'N' && ch <= 'Z') {
				stringBuilder.append((char)(ch - 13));
				continue;
			}
			if (ch >= 'a' && ch <= 'm') {
				stringBuilder.append((char)(ch + 13));
				continue;
			}
			if (ch >= 'n' && ch <= 'z') {
				stringBuilder.append((char)(ch - 13));
				continue;
			}
			stringBuilder.append(ch);
		}
		System.out.println(stringBuilder.toString());
	}
}