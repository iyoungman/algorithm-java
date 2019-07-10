package bruteforcesearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by YoungMan on 2019-07-10.
 * https://www.acmicpc.net/problem/2503
 * 각 경우마다 생각하고 있는 경우의 수를 거르면 되지 않을까
 */

public class BOJ_2503_숫자야구 {

	private static int[] isPossible = new int[1000];//~999
	private static int checkCount = 0;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			int strike = scanner.nextInt();
			int ball = scanner.nextInt();

			checkPossible(num, strike, ball);
		}

		//결과 출력
		long result = Arrays.stream(isPossible)
				.filter(i -> i == n)
				.count();

		System.out.println(result);
	}

	private static void checkPossible(int num, int strike, int ball) {

		for (int i = 123; i <= 999; i++) {
			if (isPossible[i] != checkCount || checkOverlapAndZero(i)) {//검사할 필요 없다
				continue;
			}

			if (checkContains(num, i, strike + ball) && checkStrike(num, i, strike)) {
				isPossible[i]++;
			}
		}

		checkCount++;
	}

	private static boolean checkOverlapAndZero(int num) {
		Set<Integer> nums = new HashSet<>();
		int mok = num;

		for (int i = 0; i < 3; i++) {
			if (i == 2) {
				nums.add(mok);
				continue;
			}
			nums.add(mok % 10);
			mok = mok / 10;
		}
		return nums.size() != 3 || nums.contains(0);
	}

	private static boolean checkContains(int num, int compareNum, int hap) {
		int count = 0;
		String numStr = String.valueOf(num);
		String compareNumStr = String.valueOf(compareNum);

		for (int i = 0; i < 3; i++) {
			if (compareNumStr.indexOf(numStr.charAt(i)) >= 0) {
				count++;
			}
		}

		return count == hap;
	}

	private static boolean checkStrike(int num, int compareNum, int strike) {
		int count = 0;
		String numStr = String.valueOf(num);
		String compareNumStr = String.valueOf(compareNum);

		for (int i = 0; i < 3; i++) {
			if (numStr.charAt(i) == compareNumStr.charAt(i)) {
				count++;
			}
		}

		return count == strike;
	}

}
