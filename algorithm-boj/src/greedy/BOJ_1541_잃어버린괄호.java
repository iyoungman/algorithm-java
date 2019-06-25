package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-25.
 * https://www.acmicpc.net/problem/1541
 */

public class BOJ_1541_잃어버린괄호 {

	private static long stoi(String s) {
		return Long.parseLong(s);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] subValues = input.split("-");//뺄셈을 기준으로 나누기
		long result = 0;

		for (int i = 0; i < subValues.length; i++) {
			if (subValues[i].contains("+")) {
				long sum = 0;
				String[] addValues = subValues[i].split("\\+");
				for (String addValue : addValues) {
					sum += stoi(addValue);
				}
				result = i != 0 ? result - sum : sum;
				continue;
			}
			result = i != 0 ? result - stoi(subValues[i]) : stoi(subValues[i]);
		}

		//결과 출력
		System.out.println(result);
	}
}
