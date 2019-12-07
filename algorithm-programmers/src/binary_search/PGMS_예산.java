package binary_search;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-09-19.
 */

public class PGMS_예산 {

	public static void main(String[] args) {
		int[] budgets = {9, 8, 5, 6, 7};
		int n = 5;

		System.out.println(solution(budgets, n));
	}

	/**
	 * 110 ~ 150 이분 탐색
	 */
	private static int solution(int[] budgets, int n) {
		Arrays.sort(budgets);

		long sum = 0;
		for (int i = 0; i < budgets.length; i++) {
			sum = sum + budgets[i];
		}

		if (sum <= n) {
			return budgets[budgets.length - 1];
		}

		if(budgets[0] > (n / budgets.length)) {
			return n / budgets.length;
		}

		int result = 0;
		int min = budgets[0];
		int max = budgets[budgets.length - 1];
		while (min <= max) {
			int mid = (min + max) / 2;
			sum = 0;
			for (int i = 0; i < budgets.length; i++) {
				if (budgets[i] > mid) {
					sum = sum + mid;
				} else {
					sum = sum + budgets[i];
				}
			}

			if (sum > n) {
				max = mid - 1;
			} else if (sum < n) {
				result = mid;
				min = mid + 1;
			}
		}

		return result;
	}
}
