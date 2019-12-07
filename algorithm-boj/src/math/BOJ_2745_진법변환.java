package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-04.
 * https://www.acmicpc.net/problem/2745
 * B진법 -> 10진법
 */

public class BOJ_2745_진법변환 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n = scanner.next();//수
		int b = scanner.nextInt();//진법
		int result = 0;

		for (int i = 0; i < n.length(); i++) {
			char index = n.charAt(n.length() - 1 - i);
			int num = getNum(index);
			result = result + (num * (int)Math.pow(b, i));
		}

		//결과 출력
		System.out.println(result);
	}

	private static int getNum(char index) {
		if(index >= 65 && index <= 90) {//A~Z이면
			return index - 55;
		} else {
			return index - '0';
		}
	}
}
