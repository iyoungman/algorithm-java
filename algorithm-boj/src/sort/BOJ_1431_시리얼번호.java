package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-14.
 * https://www.acmicpc.net/problem/1431
 */

public class BOJ_1431_시리얼번호 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//시리얼 번호 개수
		scanner.nextLine();

		String[] serialNumbers = new String[n];
		for (int i = 0; i < n; i++) {
			serialNumbers[i] = scanner.nextLine();
		}

		Arrays.sort(serialNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//오름차순
				if (o1.length() != o2.length()) {
					return Integer.compare(o1.length(), o2.length());
				} else {
					//오름차순
					if (getSum(o1) != getSum(o2)) {
						return Integer.compare(getSum(o1), getSum(o2));
					}
					//오름차순
					return o1.compareTo(o2);
				}
			}
		});

		//결과 출력
		for (int i = 0; i < n; i++) {
			System.out.println(serialNumbers[i]);
		}
	}

	private static int getSum(String serialNumber) {
		int sum = 0;

		for (int i = 0; i < serialNumber.length(); i++) {
			char current = serialNumber.charAt(i);
			if (current >= '1' && current <= '9') {
				sum = sum + (current - '0');
			}
		}

		return sum;
	}
}
