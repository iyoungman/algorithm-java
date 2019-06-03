package string;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-04-29.
 * 길이가 2인 문자를 1로 치환한다
 * 알파벳과 '=', '-' 으로만 구성되어있는것을 이용
 */

public class BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] convertAplabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		int count = 0;

		for (int i = 0; i < convertAplabet.length; i++) {
			if(input.length() == 0) {
				break;
			}
			if (input.contains(convertAplabet[i])) {
				int beforeLength = input.length();
				input = input.replaceAll(convertAplabet[i], "0");
			}
			if (i == convertAplabet.length - 1) {
				count = input.length();
				break;
			}
		}
		System.out.println(count);
	}
}
