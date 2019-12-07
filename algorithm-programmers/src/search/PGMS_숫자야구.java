package search;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-10-11.
 * 안되는 것들 지우기
 */

public class PGMS_숫자야구 {

	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
	}

	private static int solution(int[][] baseball) {
		boolean[] isPossible = new boolean[1000];
		Arrays.fill(isPossible, true);

		for (int[] index : baseball) {
			int num = index[0];
			int strike = index[1];
			int ball = index[2];

			for (int i = 100; i <= 999; i++) {
				if (!checkNum(i) || !isPossible[i]) {//서로 다른 3자리
					isPossible[i] = false;
					continue;
				}
				if (String.valueOf(i).contains("0")) {//0 포함 X
					isPossible[i] = false;
					continue;
				}
				if (!checkPossible(num, i, strike, ball)) {
					isPossible[i] = false;
				}
			}
		}

		int result = 0;
		for (int i = 100; i <= 999; i++) {
			if (isPossible[i]) {
				result++;
			}
		}

		return result;
	}

	private static boolean checkNum(int num) {
		char[] sNum = String.valueOf(num).toCharArray();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) continue;
				if (sNum[i] == sNum[j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkPossible(int num, int index, int s, int b) {
		int sCount = 0;
		int bCount = 0;
		String numStr = String.valueOf(num);
		String indexStr = String.valueOf(index);

		for (int i = 0; i < 3; i++) {
			if (numStr.charAt(i) == indexStr.charAt(i)) {
				sCount++;
			} else {
				if (numStr.contains(indexStr.substring(i, i + 1))) {
					bCount++;
				}
			}
		}

		return s == sCount && b == bCount;
	}
}
